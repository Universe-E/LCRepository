class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = nums[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i];
        }
        for (int i = n-1,temp = 1; i >= 0; temp *= nums[i],i--) {
            if (i == 0) res[i] = temp;
            else res[i] = res[i-1] * temp;
        }
        return res;
    }
}