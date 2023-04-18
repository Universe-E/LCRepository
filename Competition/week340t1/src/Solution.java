import java.util.TreeSet;

class Solution {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            set.add(nums[i][i]);
            set.add(nums[i][n-1-i]);
        }
        int res = 0;
        for (Integer num : set) {
            if (isPrime(num)) res = Math.max(res, num);
        }
        return res;
    }

    private boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}