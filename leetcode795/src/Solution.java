class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int p = -1,res = 0,temp = 0;
        //p作为离当前i最近的分隔点
        for (int i = 0; i < n; i++) {
            if (nums[i] > right) p = i;
            //如果当前nums[i] >= left，类似前缀和的思路，
            //从i开始，向左遍历的每个子数组：即[i-1,i],[i-2,i]...[p+1,i]都可以满足条件，且不重不漏
            if (nums[i] >= left) temp = i - p;
            res += temp;
        }
        return res;
    }
}

//第二种思路，最大元素小于等于right的子数组个数 - 最大元素小于left的子数组个数
class Solution2 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return maxOutOfBound(nums,right) - maxOutOfBound(nums,left - 1);
    }

    private int maxOutOfBound(int[] nums,int max) {
        int res = 0,sum = 0;
        //同第一种思路，每到一个分隔点重新计数
        for (int num : nums) {
            if (num > max) sum = 0;
            else sum++;
            res += sum;
        }
        return res;
    }
}