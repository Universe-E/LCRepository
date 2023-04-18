import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int[] ints : nums1) {
            int k = ints[0];
            map.put(k,ints[1]);
        }
        for (int[] ints : nums2) {
            map.merge(ints[0],ints[1],Integer::sum);
        }
        int[][] res = new int[map.keySet().size()][2];
        int i = 0;
        for (Integer k : map.keySet()) {
            res[i][0] = k;
            res[i][1] = map.get(k);
            i++;
        }
        Arrays.sort(res, Comparator.comparingInt(o -> o[0]));
        return res;
    }
}