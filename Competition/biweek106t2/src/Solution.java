class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        if (n < 2) return 1;
        int l = 0;
        int res = 0;
        for (int r = 1; r < n; r++) {
            while (!ok(s.substring(l,r+1))) l++;
            res = Math.max(res,r-l+1);
        }
        return res;
    }

    private boolean ok(String s) {
        int cnt = 0;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i),pre = s.charAt(i-1);
            if (cur == pre) cnt++;
        }
        return cnt <= 1;
    }
}