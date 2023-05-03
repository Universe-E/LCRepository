class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length,g = nums[0];
        for (int i = 1; i < n; i++) {
            g = gcd(g,nums[i]);
        }
        if (g != 1) return -1;
        boolean b = false;
        for (int i = 0; i < n-1; i++) {
            if (gcd(nums[i],nums[i+1]) == 1) {
                b = true;
                break;
            }
        }
        int cntOne = 0;
        for (int num : nums) {
            if (num == 1) cntOne++;
        }
        if (b) return n-cntOne;
        int res = 0x3f3f3f3f;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int cur = 0;
                for (int k = i; k <= j; k++) {
                    cur = gcd(cur,nums[k]);
                }
                if (cur == 1) res = Math.min(res,j-i-1+n);
            }
        }
        return res;
    }

    private int gcd(int a,int b) {
        return b == 0 ? a : gcd(b,a%b);
    }
}