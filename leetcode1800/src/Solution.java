import java.util.Arrays;

class Solution {
    public int maxAscendingSum(int[] nums) {
        int[] diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            diff[i] = nums[i] > nums[i - 1] ? nums[i] + diff[i - 1] : nums[i];
        return Arrays.stream(diff).max().getAsInt();
    }
}