import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        //maxs[i]表示[0,i]的最大值，mins[i]表示[i,n - 1]的最小值
        int[] maxs = new int[n],mins = new int[n];
        maxs[0] = nums[0];
        mins[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            maxs[i] = Math.max(nums[i],maxs[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            mins[i] = Math.min(nums[i],mins[i + 1]);
        }
        //如果nums升序，则maxs[i] <= mins[i]
        int start = -1, end = -1;
        for (int i = 0; i < n; i++) {
            if (maxs[i] > mins[i]) {
                start = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (maxs[i] > mins[i]) {
                end = i;
                break;
            }
        }
        return (start == -1 && end == -1) ? 0 : end - start + 1;
    }
}