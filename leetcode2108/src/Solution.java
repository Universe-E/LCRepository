class Solution {
    public String firstPalindrome(String[] words) {
        for (String w : words) {
            if (ok(w)) return w;
        }
        return "";
    }

    private boolean ok(String w) {
        int n = w.length();
        for (int i = 0,j = n-1;i < j; i++,j--) {
            if (w.charAt(i) != w.charAt(j)) return false;
        }
        return true;
    }
}