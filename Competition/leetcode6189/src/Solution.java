class Solution {
    //按位与不会产生比max更大的数字，任何小于max的数字与max按位与结果均小于max
    public int longestSubarray(int[] nums) {
        int res = 0, cur = 0,max = 0,n = nums.length;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        for (int num : nums) {
            if (num == max) {
                cur++;
                res = Math.max(res,cur);
            }
            else cur = 0;
        }
        return res;
    }
}