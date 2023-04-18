import java.util.Arrays;

class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int l = 0,r = 0;
        while (r < nums.length) {
            int cur = nums[r];
            if (cur > nums[l]) l++;
            r++;
        }
        return l;
    }
}