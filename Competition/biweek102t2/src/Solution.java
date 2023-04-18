class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length,mx = 0;
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx,nums[i]);
            nums[i] += mx;
            if (i == 0) res[i] = nums[i];
            else res[i] = res[i-1] + nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {(int) 1e9,(int)1e9,(int)1e9};
        long[] res = new Solution().findPrefixScore(nums);
        for (long re : res) {
            System.out.println(re);
        }
    }
}