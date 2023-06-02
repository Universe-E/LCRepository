import java.util.HashMap;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String,Integer> map = new HashMap<>();
        for (int[] ints : grid) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(ints[j]).append(',');
            }
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            for (int[] ints : grid) {
                sb.append(ints[j]).append(',');
            }
            String s = sb.toString();
            res += map.getOrDefault(s,0);
        }
        return res;
    }
}