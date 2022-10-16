import java.util.Arrays;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int diff = sum / k;
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] > diff) return false;
        int[] cnt = new int[k];
        Arrays.fill(cnt,diff);
        return backTrack(nums,cnt,n - 1);
    }

    /**
     *
     * @param nums 目标数组
     * @param cnt 临时数组
     * @param p 当前索引
     */
    private boolean backTrack(int[] nums,int[] cnt,int p) {
        if (p < 0) return true;
        for (int i = 0; i < cnt.length; i++) {
            ///如果正好能放下当前的数或者放下当前的数后，还有机会继续放前面的数（剪枝）
            if (nums[p] == cnt[i] ||(p > 0 && cnt[i] - nums[p] >= nums[0])) {
                cnt[i] -= nums[p];
                if (backTrack(nums,cnt,p - 1)) return true;
                cnt[i] += nums[p];
            }
        }
        return false;
    }
}