class Solution {
    public static final int M = (int)(1e9+7);
    public int countHomogenous(String s) {
        long res = 0,cnt = 1;
        int n = s.length();
        char c = s.charAt(0);
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == c) cnt++;
            else {
                res += cnt*(cnt+1)/2;
                c = s.charAt(i);
                cnt = 1;
            }
        }
        res += cnt*(cnt+1)/2;
        return (int) (res%M);
    }
}