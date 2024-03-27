class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0,n = nums.length,l1 = 0,l2 = 0,cnt1 = 0,cnt2 = 0;
        for (int r = 0; r < n; r++) {
            cnt1 += nums[r];
            cnt2 += nums[r];
            while (l1 <= r && cnt1 > goal) cnt1 -= nums[l1++];
            while (l2 <= r && cnt2 >= goal) cnt2 -= nums[l2++];
            res += l2-l1;
        }
        return res;
    }
}