import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
