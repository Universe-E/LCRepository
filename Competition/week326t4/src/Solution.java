import java.util.Arrays;

class Solution {
    public int[] closestPrimes(int left, int right) {
        int pre = -1, diff = Integer.MAX_VALUE, l = 0, r = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (pre != -1 && i - pre < diff) {
                    diff = i - pre;
                    l = pre;
                    r = i;
                }
                pre = i;
            }
        }
        if (r - l == 0) return new int[] {-1,-1};
        return new int[] {l,r};
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] arr = new Solution().closestPrimes(10,19);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
        System.out.println(Arrays.toString(arr));
    }
}