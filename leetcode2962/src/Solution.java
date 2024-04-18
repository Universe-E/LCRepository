class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length,mx = 0,cnt = 0;
        for (int num : nums) {
            mx = Math.max(mx,num);
        }
        long res = (long) n*(n+1)/2;
        for (int i = 0,l = 0; i < n; i++) {
            if (nums[i] == mx) cnt++;
            while (l < i && cnt >= k) {
                if (nums[l] == mx) cnt--;
                l++;
            }
            //此时的[l,i]不满足条件
            if (cnt < k) res -= i-l+1;
        }
        return res;
    }
}