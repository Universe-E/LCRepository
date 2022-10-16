import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {
    //这里valuei是唯一的，落在1-1000范围内，故可以直接设置数组大小为1001
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();
        int[] cntMap = new int[1001];
        //直接设置数组索引i为item的value值，cntMap[i]为item的weight值，不需要先转成keySet再排序
        for (int[] p : items1) {
            cntMap[p[0]] += p[1];
        }
        for (int[] p : items2) {
            cntMap[p[0]] += p[1];
        }
        for (int i = 0; i <= 1000; i++) {
            if (cntMap[i] != 0) res.add(Arrays.asList(i, cntMap[i]));
        }
        return res;
    }
}
