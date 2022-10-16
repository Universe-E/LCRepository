import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            //如果出现重复数字，则不再遍历
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1, l = nums.length - 1;
                while (k < l) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        k++;
                        continue;
                    }
                    if (l < nums.length - 1 && nums[l] == nums[l + 1]) {
                        l--;
                        continue;
                    }
                    int sum;
                    if (Math.abs(nums[i] / 10 + nums[j] / 10 + nums[k] / 10 + nums[l] / 10) < Integer.MAX_VALUE / 10) {
                        sum = nums[i] + nums[j] + nums[k] + nums[l];
                    }
                    else break;
                    if (sum == target) {
                        List<Integer> curList = new ArrayList<>();
                        curList.add(nums[i]);
                        curList.add(nums[j]);
                        curList.add(nums[k]);
                        curList.add(nums[l]);
                        resList.add(curList);
                    }
                    else if (sum > target) {
                        l--;
                        continue;
                    }
                    k++;
                }
            }
        }
        return resList;
    }
}
