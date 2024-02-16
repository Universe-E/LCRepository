import java.util.Arrays;

class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long res = -1, sum = 0;
        for (int num : nums) {
            if (num < sum) res = Math.max(res, sum + num);
            sum += num;
        }
        return res;
    }
}