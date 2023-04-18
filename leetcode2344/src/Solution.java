import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(numsDivide);
        int g = numsDivide[0];
        for (int value : numsDivide) {
            g = Math.min(g, gcd(g, value));
        }
        Arrays.sort(nums);
        int cnt = 0;
        for (int num : nums) {
            if (g % num != 0) cnt++;
            else break;
        }
        return cnt == nums.length ? -1 : cnt;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}