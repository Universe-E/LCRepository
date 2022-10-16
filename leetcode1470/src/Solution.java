class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] temp1 = new int[n],temp2 = new int[n];
        System.arraycopy(nums, 0, temp1, 0, n);
        System.arraycopy(nums,n,temp2,0,n);
        int i = 0,j = 0, k = 0;
        while (k < nums.length) {
            if (k % 2 == 0) {
                nums[k] = temp1[i];
                i++;
            }
            else {
                nums[k] = temp2[j];
                j++;
            }
            k++;
        }
        return nums;
    }
}
