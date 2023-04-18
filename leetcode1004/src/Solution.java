class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length,cnt = 0,left = 0,res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) cnt++;
            while (cnt > k) {
                if (nums[left] == 0) cnt--;
                left++;
            }
            res = Math.max(res,i - left + 1);
        }
        return res;
    }
}