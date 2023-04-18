class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] pre = new int[n+1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i-1] + nums[i-1];
        }
        int max = 0;
        for (int i = firstLen; i <= n-secondLen; i++) {
            for (int j = i; j <= n-secondLen; j++) {
                max = Math.max(max,pre[i] - pre[i-firstLen] + pre[j+secondLen] - pre[j]);
            }
        }
        for (int i = secondLen; i <= n-firstLen; i++) {
            for (int j = i; j <= n-firstLen; j++) {
                max = Math.max(max,pre[i] - pre[i-secondLen] + pre[j+firstLen] - pre[j]);
            }
        }
        return max;
    }
}