import java.util.ArrayList;

class Solution {
    public int smallestValue(int n) {
        if (n == 4) return 4;
        while (!isPrime(n)) {
            int[] primes = getPrime(n);
            int sum = 0;
            for (int prime : primes) {
                sum += prime;
            }
            System.out.println(sum);
            n = sum;
        }
        return n;
    }

    private int[] getPrime(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int k = 2;
        while (k <= n) {
            if (n % k == 0) {
                if (isPrime(k)) {
                    list.add(k);
                    n /= k;
                }
            }
            else k++;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        new Solution().smallestValue(n);
    }
}