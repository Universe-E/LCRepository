class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] maxs = new int[n],mins = new int[n];
        maxs[0] = nums[0];
        mins[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            maxs[i] = Math.max(maxs[i - 1],nums[i]);
            mins[n-i-1] = Math.min(mins[n-i],nums[n-i-1]);
        }
        for (int i = 0; i < n - 1; i++) {
            if (maxs[i] <= mins[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }
}

class Solution2 {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int curMax = nums[0],p = 0,leftMax = nums[0];
        for (int i = 1; i < n; i++) {
            curMax = Math.max(curMax,nums[i]);
            //如果当前i不能满足分割条件，则更新当前的leftMax
            if (nums[i] < leftMax) {
                leftMax = curMax;
                p = i;
            }
        }
        return p+1;
    }
}