import java.util.Arrays;

class Solution {
    public static final int M = (int) 1e9+7;
    public int sumOfPower(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long minSum = nums[0];
        long cur = (long) nums[0]*nums[0]%M*minSum%M;
        for (int i = 1; i < n; i++) {
            minSum = (minSum*2-nums[i-1]+nums[i])%M;
            cur = (cur + (long) nums[i]*nums[i]%M*minSum%M)%M;
        }
        return (int) cur;
    }
}