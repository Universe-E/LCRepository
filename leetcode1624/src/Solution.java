import java.util.Arrays;

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] cnt = new int[26];
        Arrays.fill(cnt, -1);
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            //如果该字母之前已经出现过，则更新res最大值
            if (cnt[s.charAt(i) - 'a'] != -1) res = Math.max(res,i - 1 - cnt[s.charAt(i) - 'a']);
            //记录第一次出现的位置
            else cnt[s.charAt(i) - 'a'] = i;
        }
        return res;
    }
}