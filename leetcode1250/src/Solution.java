class Solution {
    public boolean isGoodArray(int[] nums) {
        int n = nums.length;
        int a = nums[0];
        for (int i = 1; i < n; i++) {
            a = gcd(a,nums[i]);
            if (a == 1) return true;
        }
        return a == 1;
    }
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b,a%b);
    }
}