import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //首先声明三数之和sum为nums[0] + nums[1] + nums[nums.length - 1]，即初始值
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                //这里声明当前的三个数之和
                int currentSum = nums[i] + nums[j] + nums[k];
                if (Math.abs(currentSum - target) < Math.abs(sum - target)) sum = currentSum;
                if (currentSum < target) j++;
                else if (currentSum > target) k--;
                else return target;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,0,-1,-2,-3};
        int target = 999;
        int res = new Solution().threeSumClosest(nums,target);
        System.out.println(res);
    }
}
