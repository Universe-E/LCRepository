import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        int n = queries.length;
        HashMap<Integer,int[]> map = new HashMap<>();
        for (int i = 30; i >= 1; i--) {
            //从后往前找，确认更新的是最前面的索引j
            for (int j = s.length()-i; j >= 0; j--) {
                map.put(Integer.valueOf(s.substring(j,j+i),2),new int[] {j,j+i-1});
            }
        }
        int[][] res = new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] q = queries[i];
            int t = q[0]^q[1];
            if (!map.containsKey(t)) res[i] = new int[] {-1,-1};
            else res[i] = Arrays.copyOf(map.get(t),2);
        }
        return res;
    }
}