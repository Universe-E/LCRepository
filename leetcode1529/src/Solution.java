class Solution {
    public int minFlips(String target) {
        int n = target.length();
        char c = target.charAt(0);
        int res = c=='0' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            if (target.charAt(i) != c) {
                res++;
                c = target.charAt(i);
            }
        }
        return res;
    }
}