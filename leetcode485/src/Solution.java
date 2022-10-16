class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0,cur = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            if (i != nums.length && nums[i] == 1) cur++;
            else {
                res = Math.max(res,cur);
                cur = 0;
            }
        }
        return res;
    }
}
