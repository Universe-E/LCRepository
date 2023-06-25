class Solution {
    private static final int M = (int) 1e9+7;
    public int numberOfGoodSubarraySplits(int[] nums) {
        int n = nums.length;
        int l = 0,r = n-1;
        int res = 1;
        //找到首尾第一个出现1的位置，然后开始遍历
        while (l < n && nums[l] == 0) l++;
        while (r >= 0 && nums[r] == 0) r--;
        //不含1
        if (l > r) return 0;
        //只有一个1
        if (l == r) return 1;
        for (int i = l,cur = 0; i <= r; i++) {
            if (nums[i] == 0) cur++;
            else {
                res = (int) ((long)res*(cur+1)%M);
                cur = 0;
            }
        }
        return res;
    }
}