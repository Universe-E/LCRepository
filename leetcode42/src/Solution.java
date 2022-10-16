class Solution {
    public int trap(int[] height) {
        int n = height.length;
        //lHs[i]对应[0,i-1]左侧最大值，rHs[i]对应[i+1,n-1]右侧最大值
        int[] lHs = new int[n],rHs = new int[n];
        for (int i = 1; i < n; i++) {
            lHs[i] = Math.max(lHs[i-1],height[i-1]);
            rHs[n-i-1] = Math.max(rHs[n-i],height[n-i]);
        }
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            res += Math.max(0,Math.min(lHs[i],rHs[i]) - height[i]);
        }
        return res;
    }
}