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
