import java.util.HashMap;

class Solution {
    public static final int M = (int)1e9 +7;
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            String s = String.valueOf(num);
            int cur = 0;
            for (int j = s.length()-1; j >= 0; j--) {
                cur = cur * 10 + s.charAt(j) - '0';
            }
            //放入作差后的结果
            map.put(num - cur, map.getOrDefault(num - cur, 0) + 1);
        }
        long res = 0;
        for (Integer key : map.keySet()) {
            int val = map.get(key);
            res = (res + ((long)val*(val-1)/2)%M)%M;
        }
        return (int) res;
    }
}