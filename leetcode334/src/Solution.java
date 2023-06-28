class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        for (int i = 0,pre = Integer.MAX_VALUE,cur = Integer.MAX_VALUE;i < n;i++) {
            //如果出现小于，则pre和cur都重置
            if (nums[i] <= pre) pre = nums[i];
            else if (nums[i] <= cur) cur = nums[i];
            else return true;
        }
        return false;
    }
}