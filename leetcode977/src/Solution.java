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

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length,l = 0,r = n - 1;
        int[] res = new int[n];
        int j = n - 1;
        //由于nums已经排序，故平方后结果直接左右比较，将较大者从右至左放入res数组中
        while (l <= r) {
            int l2 = nums[l] * nums[l],r2 = nums[r] * nums[r];
            if (l2 > r2) {
                res[j] = l2;
                l++;
            }
            else {
                res[j] = r2;
                r--;
            }
            j--;
        }
        return res;
    }
}
