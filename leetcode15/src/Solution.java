import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            //以下两种情况直接跳过此次循环：
            //1、nums[i] > 0;
            //2、nums[i]和前一个元素相同，即已经遍历过一次
            if (nums[i] > 0 || (i > 0 && nums[i] == nums[i - 1])) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                //确定i以后，对i+1到nums.length-1的双指针遍历，以下情况需要去重
                //1、当j > i + 1时nums[j]和前一个元素相同
                //2、当k < nums.length - 1时nums[k]和后一个元素相同
                if ((j > i + 1 && nums[j] == nums[j - 1])) {
                    j++;
                    continue;
                }
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                //如果刚好满足条件就加到List里去
                if (sum == 0) {
                    List<Integer> curList = new ArrayList<>();
                    curList.add(nums[i]);
                    curList.add(nums[j]);
                    curList.add(nums[k]);
                    resList.add(curList);
                }
                else if (sum > 0) {
                    k--;
                    continue;
                }
                j++;
            }
        }
        return resList;
    }
}
