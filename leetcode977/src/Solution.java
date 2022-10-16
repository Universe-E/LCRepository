import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i],2);
        }
        Arrays.sort(nums);
        return nums;
    }
}

class Solution2 {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[nums.length];
        int j = nums.length - 1;
        //由于nums已经排序，故平方后结果直接左右比较，将较大者从右至左放入res数组中
        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                res[j] = nums[l] * nums[l];
                l++;
                j--;
            }
            else {
                res[j] = nums[r] * nums[r];
                r--;
                j--;
            }
        }
        return res;
    }
}
