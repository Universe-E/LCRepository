class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) count += isPrime(i) ? 1 : 0;
        return count;
    }

    private boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }

}
