import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        double avg = 0;
        for (int i = 0; i <= n - k; i++) {
            avg += nums[i];
        }
        avg /= n-k+1;
        for (int i = n-k+1; i < n; i++) {
            avg += nums[i];
        }
        return avg;
    }
}