class Solution {
    public long countQuadruplets(int[] nums) {
        int n=nums.length;
        // 题解采用的思路是，在题目描述给的 i, j, k, l 中，枚举第二个（"j"）和第四个（"l"）,
        // 然后对于每个 "j" "l" 对，统计以 "j" 为 "中间" 的、且在 "l" 之前的 132 模式数量。

        // 定义 v[j] 为当前的以 j 为 "中间" 的 "132" 模式的数量
        int[] v = new int[n];

        // 答案
        long res = 0;

        // 先枚举 l, 再枚举 j(j < l)
        for(int l = 0; l < n; ++l) {
            // 先从小到大枚举 j 统计答案
            // 此时，如果 nums[j] < nums[l]，那么答案就应当加上以 j 为 "中间" 的 "132" 数量
            for(int j = 0; j < l; ++j)
                if(nums[j] < nums[l]) res += v[j];

            // 然后，再统计，由于 nums[l] 的加入，导致以 nums[j] 为中间的 "132" 模式数量的 "变化量".
            // 同样从小到大枚举 j.
            // 下面的 count 就表示在 nums[j] 之前的、小于 nums[l] 的数字个数。
            // 这个数量在枚举时同时统计即可，下面用 count 进行统计。
            for(int j = 0, count = 0; j < l; ++j) {
                // 只要 nums[j] > nums[l]，那么以 j 为中间的模式数量（v[j]）
                // 应当加上 nums[j] 之前的、小于 nums[l] 的数量, 也就是 count
                if(nums[j] > nums[l]) v[j] += count;
                // 同时，维护 count
                if (nums[j] < nums[l]) count++;
            }
        }

        return res;
    }
}