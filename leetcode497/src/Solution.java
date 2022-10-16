import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Solution {
    List<Integer> list;
    Random random;
    int[][] rects;

    public Solution(int[][] rects) {
        list = new ArrayList<>();
        random = new Random();
        this.rects = rects;
        list.add(0);
        //将当前所有矩形的面积和加入到list中，即list.get(i)的结果是从1到i所有矩形的点阵数量和
        for (int[] rect : rects) {
            int curArea = list.get(list.size() - 1), a = rect[0], b = rect[1], x = rect[2], y = rect[3];
            list.add(curArea + (x - a + 1) * (y - b + 1));
        }
    }

    public int[] pick() {
        //k的点数范围在[1,最大点数]之间，即[0,最大点数)加1
        int k = 1 + random.nextInt(list.get(list.size() - 1));
        int idx = search(list, k);//idx表示rects数组中矩形索引
        k -= list.get(idx);//表示这是矩形的第k个点
        int a = rects[idx][0], b = rects[idx][1], x = rects[idx][2], y = rects[idx][3];
        //当前矩形x轴所有点，注意总点数是宽度+1
        int width = x - a + 1;
        //flats和floors分别代表偏移量
        //第k个点所在位置即 (a + flats, b + floors)
        int flats = (k - 1) % width;
        int floors = (k - 1) / width;
        return new int[] {a + flats, b + floors};
    }

    //找到当前k所属的矩形所在索引，即找list中小于k的最大值
    private int search(List<Integer> list, int k) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            //由于左边界可能不更新，因此mid向上取整
            int mid = (l + r + 1) / 2;
            int cur = list.get(mid);
            if (cur < k) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}
