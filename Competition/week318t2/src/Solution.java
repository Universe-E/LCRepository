import java.util.HashSet;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[100005];
        HashSet<Integer> set = new HashSet<>();
        long sum = 0;
        for (int i = 0; i < k; i++) {
            cnt[nums[i]]++;
            if (cnt[nums[i]] > 1) set.add(nums[i]);
            sum += nums[i];
        }
        long res = set.isEmpty() ? sum : 0;
        for (int i = k; i < n; i++) {
            cnt[nums[i-k]]--;
            if (cnt[nums[i-k]] <= 1) set.remove(nums[i-k]);
            cnt[nums[i]]++;
            if (cnt[nums[i]] > 1) set.add(nums[i]);
            sum += nums[i] - nums[i-k];
            if (set.isEmpty()) res = Math.max(res,sum);
        }
        return res;
    }
}