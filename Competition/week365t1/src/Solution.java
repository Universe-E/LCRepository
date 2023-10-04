class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        //分别找前缀最大值和后缀最大值
        int[] letMax = new int[n];
        int[] rightMax = new int[n];
        letMax[0] = nums[0];
        rightMax[n-1] = nums[n-1];
        for (int i = 1; i < n; i++) {
            letMax[i] = Math.max(letMax[i-1],nums[i]);
            rightMax[n-i-1] = Math.max(rightMax[n-i],nums[n-i-1]);
        }
        long ans = 0;
        //对于ij，nums[j]为当前值，leftMax[i]为此前的最大值，对于k，用rightMax[i+1]表示当前值之后的最大乘数
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans,(long) (letMax[i]-nums[i]) * rightMax[i+1]);
        }
        return ans;
    }
}