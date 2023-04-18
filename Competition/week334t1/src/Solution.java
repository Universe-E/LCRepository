class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int[] l = new int[n], r = new int[n];
        for (int i = 1; i < n; i++) {
            l[i] = l[i-1] + nums[i-1];
            r[n-i-1] = r[n-i] + nums[n-i];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.abs(l[i]-r[i]);
        }
        return ans;
    }
}