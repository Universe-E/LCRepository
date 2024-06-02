class Solution {
    public int distributeCandies(int n, int limit) {
        int res = 0;
        for (int i = 0; i <= Math.min(n,limit); i++) {
            for (int j = 0; j <= Math.min(n-i,limit); j++) {
                if (n-i-j <= limit) res++;
            }
        }
        return res;
    }
}