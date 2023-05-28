import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int[] mat : matrix) {
            StringBuilder sb = new StringBuilder();
            for (int value : mat) {
                sb.append(value);
            }
            String s = sb.toString();
            map.put(s,map.getOrDefault(s,0)+1);
        }
        int res = 0;
        for (String s : map.keySet()) {
            String rs = reverse(s);
            res = Math.max(res,map.get(s)+map.getOrDefault(rs,0));
        }
        return res;
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c == '0' ? 1 : 0);
        }
        return sb.toString();
    }
}