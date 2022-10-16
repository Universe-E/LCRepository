import java.util.Arrays;

class Solution {
    //差分数组
    public int bestRotation(int[] nums) {
        int n = nums.length;
        //cnt[k]表示k时nums数组中不得分的个数
        int[] cnt = new int[n];
        //对于nums[i]，当其位于索引i = nums[i]及后面时均可以得分，此时需要左移i - nums[i] + n次
        //因此恰好不得分需要左移i - nums[i] + n + 1次
        for (int i = 0; i < nums.length; i++) {
            cnt[(i - nums[i] + n + 1) % n]++;
        }
        //当k++时，原本处于cnt[0]处的元素开始得分
        //找最小的k，即找cnt中的最小值
        int res = 0;
        for (int i = 1; i < n; i++) {
            cnt[i] += cnt[i - 1] - 1;
            if (cnt[i] < cnt[res]) res = i;
        }
        return res;
    }
}