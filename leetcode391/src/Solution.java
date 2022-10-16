import java.util.HashMap;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        //用String记录键而不是int数组，因为字符串常量池不重复
        HashMap<String,Integer> pointMap = new HashMap<>();
        //声明所有矩形面积之和
        int sumArea = 0;
        for (int[] r : rectangles) {
            putFourPoints(r,pointMap);
            //最后将矩形面积相加
            sumArea += getArea(r);
        }

        int[] leftDown = new int[] {100001,100001},rightUp = new int[] {-100001,-100001},
            leftUp = new int[] {100001,-100001},rightDown = new int[] {-100001,100001};
        int count = 0;//如果是完美矩形，则有且仅有4个点不重合
        //找到矩形四角的点，以及所有点出现的次数
        for (String r : pointMap.keySet()) {
            if (getXAxis(r) <= leftDown[0] && getYAxis(r) <= leftDown[1]) leftDown = new int[]{getXAxis(r), getYAxis(r)};
            if (getXAxis(r) <= leftUp[0] && getYAxis(r) >= leftUp[1]) leftUp = new int[]{getXAxis(r), getYAxis(r)};
            if (getXAxis(r) >= rightUp[0] && getYAxis(r) >= rightUp[1]) rightUp = new int[]{getXAxis(r), getYAxis(r)};
            if (getXAxis(r) >= rightDown[0] && getYAxis(r) <= rightDown[1]) rightDown = new int[]{getXAxis(r), getYAxis(r)};
            if (pointMap.get(r) == 1) count++;
            if (count > 4 || ((pointMap.get(r) > 2) && pointMap.get(r) % 2 != 0)) return false;
        }
        return sumArea == (rightUp[0] - leftDown[0]) * (rightUp[1] - leftDown[1]) && count == 4
                &&pointMap.get(arrayToString(leftDown)) == 1 && pointMap.get(arrayToString(rightDown)) == 1
                && pointMap.get(arrayToString(leftUp)) == 1 && pointMap.get(arrayToString(rightUp)) == 1;
    }

    private int getArea(int[] rect) {
        return (rect[2] - rect[0]) * (rect[3] - rect[1]);
    }

    private void putFourPoints(int[] r,HashMap<String,Integer> pointMap) {
        //下面放入矩形的四个坐标
        String r1 = r[0] + " " + r[1];//左下
        String r2 = r[0] + " " + r[3];//左上
        String r3 = r[2] + " " + r[1];//右下
        String r4 = r[2] + " " + r[3];//右上
        if (pointMap.containsKey(r1)) {
            int value = pointMap.get(r1);
            pointMap.put(r1,value + 1);
        } else pointMap.put(r1,1);
        if (pointMap.containsKey(r2)) {
            int value = pointMap.get(r2);
            pointMap.put(r2,value + 1);
        } else pointMap.put(r2,1);
        if (pointMap.containsKey(r3)) {
            int value = pointMap.get(r3);
            pointMap.put(r3,value + 1);
        } else pointMap.put(r3,1);
        if (pointMap.containsKey(r4)) {
            int value = pointMap.get(r4);
            pointMap.put(r4,value + 1);
        } else pointMap.put(r4,1);
    }

    private int getXAxis(String key) {
        return Integer.parseInt(key.substring(0,key.indexOf(" ")));
    }

    private int getYAxis(String key) {
        return Integer.parseInt(key.substring(key.indexOf(" ") + 1));
    }
    private String arrayToString(int[] arr) {
        return arr[0] + " " + arr[1];
    }
}
