class Solution {
    public int maxProduct(int[] nums) {
        int cur = 1, max = nums[0];
        //从左往右遍历非0的子数组，找到最大值
        for (int num : nums) {
            cur *= num;
            max = Math.max(max,cur);
            if (num == 0) cur = 1;
        }
        cur = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            cur *= nums[i];
            max = Math.max(max,cur);
            if (nums[i] == 0) cur = 1;
        }
        return max;
    }
}