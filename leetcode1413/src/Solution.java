import java.util.Arrays;

class Solution {
    public int minStartValue(int[] nums) {
        int min = nums[0];  //nums[i]左侧和的最小值
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            min = Math.min(min,nums[i]);
        }
        return min > 0 ? 1 : Math.abs(min) + 1;
    }
}
