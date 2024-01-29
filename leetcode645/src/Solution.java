import java.util.Arrays;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] res = new int[2];
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i-1]) res[0] = nums[i];
            if (nums[i] == nums[i-1] + 2) res[1] = nums[i] - 1;
        }
        if (res[1] == 0) {
            if (nums[n-1] == n) res[1] = 1;
            if (nums[0] == 1) res[1] = n;
        }
        return res;
    }
}