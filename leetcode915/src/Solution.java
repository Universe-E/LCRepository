import java.util.Arrays;

class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] maxs = new int[n],mins = new int[n];
        maxs[0] = nums[0];
        mins[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            maxs[i] = Math.max(maxs[i - 1],nums[i]);
        }
        System.out.println(Arrays.toString(maxs));
        for (int i = n - 2; i >= 0; i--) {
            mins[i] = Math.min(mins[i + 1],nums[i]);
        }
        System.out.println(Arrays.toString(mins));
        for (int i = 0; i < n - 1; i++) {
            if (maxs[i] <= mins[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }
}