import java.util.Arrays;

class Solution {
    public int longestSubstring(String s, int k) {
        if (k == 1) return s.length();
        if (s.length() == 0 || k > s.length()) return 0;
        int[] cnt = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            if (cnt[s.charAt(i) - 'a'] < k) pos[i] = 1;
        }
        //首先，从i = 0开始找到左段连续的0，进行递归操作
        int i = 0;
        while (i < n && pos[i] != 1) i++;
        if (i == n) return n;
        int l = longestSubstring(s.substring(0,i),k);
        //接下来跳过中间不符合条件的部分（即pos[i] = 1的位置），并对右段进行遍历
        while (i < n && pos[i] == 1) i++;
        int r = longestSubstring(s.substring(i),k);
        return Math.max(l,r);
    }

    public static void main(String[] args) {
        String s = "aaacbbb";
        int k = 3;
        System.out.println(new Solution().longestSubstring(s,k));
    }
}