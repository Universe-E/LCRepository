import java.util.Arrays;

class Solution {
    public int maxProduct(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                res = Math.max(res,(nums[i] - 1) * (nums[j] - 1));
            }
        }
        return res;
    }
}

class Solution2 {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}
