class Solution {
    public void moveZeroes(int[] nums) {
        //设k为当前指针，i为右指针
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果遇到非零元素，则交换位置
            if (nums[i] != 0) {
                //一种特殊的情况是，所有的元素都非零，此时所有的元素都和自己交换位
                //因此可以判断i和k相等时不必交换
                if (i != k) {
                    int t = nums[i];
                    nums[i] = nums[k];
                    nums[k] = t;
                }
                k++;
            }
        }
    }
}

