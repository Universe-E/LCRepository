import java.util.Arrays;

class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        long suf = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            suf += nums[i];
            if (suf > 0) cnt++;
            else break;
        }
        return cnt;
    }
}