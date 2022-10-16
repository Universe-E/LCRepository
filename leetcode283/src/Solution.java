class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) return;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                boolean isAllZero = true;
                for (int j = i; j < nums.length - 1; j++) {
                    int temp = nums[j + 1];
                    if (temp != 0) isAllZero = false;
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
                if (isAllZero) break;
            }
            else i++;
        }
    }
}
