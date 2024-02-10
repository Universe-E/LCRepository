class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i,right = i;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    res++;
                    left--;
                    right++;
                }
                else break;
            }
            if (i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                left = i;
                right = i + 1;
                while (left >= 0 && right < s.length()) {
                    if (s.charAt(left) == s.charAt(right)) {
                        res++;
                        left--;
                        right++;
                    }
                    else break;
                }
            }
        }
        return res;
    }
}

class Solution {
    public int countSubstrings(String s) {
        int n = s.length(),res = 0;
        for (int i = 0; i < n; i++) {
            int l = i,r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }
            l = i-1;
            r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }
        }
        return res;
    }
}