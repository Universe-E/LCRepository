import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        //将二维数组添加入list中，并按照一维数组的左边界从小到大排序
        List<int[]> list = new ArrayList<>();
        Collections.addAll(list, intervals);
        list.sort(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i)[1] >= list.get(i + 1)[0]) {
                //满足条件则修改为合并后的结果，合并之后将所有子数组删除，索引返回合并后的新数组
                list.set(i,new int[] {list.get(i)[0], Math.max(list.get(i)[1],list.get(i + 1)[1])});
                list.remove(i + 1);
                i--;
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        int l = -1,r = -1;
        Arrays.sort(intervals,Comparator.comparingInt(o -> o[0]));
        for (int[] interval : intervals) {
            if (interval[0] <= r) r = Math.max(r, interval[1]);
            else {
                list.add(new int[]{l, r});
                l = interval[0];
                r = interval[1];
            }
        }
        if (l > list.get(list.size()-1)[1]) list.add(new int[] {l,r});
        int[][] res = new int[list.size()-1][];
        for (int i = 1; i < list.size(); i++) {
            res[i-1] = list.get(i);
        }
        return res;
    }
}
