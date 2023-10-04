class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        for (int i = 0,j = n-1; i < j;) {
            if (nums[i] % 2 == 1) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j--] = t;
            }
            else i++;
        }
        return nums;
    }
}