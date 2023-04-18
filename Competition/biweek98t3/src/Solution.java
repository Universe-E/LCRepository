import java.util.Arrays;

class Solution {
    public int minImpossibleOR(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 1) return 1;
        int r = 1;
        for (int i = 1; i < nums.length; i++) {
            if (r < nums[i]-1) return r+1;
            r |= nums[i];
        }
        return r+1;
    }
}