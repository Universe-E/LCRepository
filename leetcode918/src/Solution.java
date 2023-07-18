class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) return nums[0];
        //find the max and min sum of subarray
        int curMax = 0,curMin = 0,sum = 0,
                mx = Integer.MIN_VALUE,mn = Integer.MAX_VALUE,
                maxNum = Integer.MIN_VALUE,minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            //add if curMax >= 0
            curMax = num + Math.max(curMax, 0);
            //add if curMin <= 0
            curMin = num + Math.min(curMin, 0);
            maxNum = Math.max(maxNum,num);
            minNum = Math.min(minNum,num);
            mx = Math.max(mx, curMax);
            mn = Math.min(mn, curMin);
        }
        //if all elements are non-positive, return maximum element
        return Math.max(mx,mn==sum ? maxNum : (sum-mn));
    }
}