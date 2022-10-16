import java.util.*;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        //先排序
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int p = nums.length - 1,leftSum = 0,rightSum = 0;
        res.add(nums[p]);
        //初始时左侧和等于0 - nums.length - 2求和，右侧和等于nums[nums.length - 1]
        for (int j = 0; j < p; j++) leftSum += nums[j];
        rightSum = nums[p];
        while (true) {
            if (rightSum > leftSum) break;
            //如果右侧和不大于左侧则继续往res中添加元素
            else {
                p--;
                res.add(nums[p]);
                leftSum -= nums[p];
                rightSum += nums[p];
            }
        }
        //最后倒序排序不就行了（xiao）
        res.sort(Comparator.reverseOrder());
        return res;
    }
}
