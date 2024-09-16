import java.util.HashMap;

class Solution {
    public static final String VOWELS = "aeiou";
    public int findTheLongestSubstring(String s) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = s.length(), mask = 0, res = 0;
        map.put(0,-1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                if (s.charAt(i) == VOWELS.charAt(j)) {
                    mask ^= (1 << (4-j));
                    break;
                }
            }
            //该状态出现过，则和最早一次的长度差值就是包含偶数次每个元音的最长字符串
            if (map.containsKey(mask)) {
                res = Math.max(res,i-map.get(mask));
            }
            //如果已有当前状态，则跳过
            map.putIfAbsent(mask,i);
        }
        return res;
    }
}