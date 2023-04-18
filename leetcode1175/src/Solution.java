class Solution {
    public static final int M = (int)(1e9+7);
    public int numPrimeArrangements(int n) {
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) cnt++;
        }
        long res = 1;
        for (int i = 1; i <= cnt; i++) {
            res = res * i % M;
        }
        for (int i = 1; i <= n - cnt; i++) {
            res = res * i % M;
        }
        return (int)res;
    }


}