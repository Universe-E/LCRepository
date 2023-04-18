class Solution {
    //三路快排partition的过程解决该问题
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zero = -1;//[0,zero]区间为0，因此默认zero为-1
        int two = n;//[two,n-1]区间为2，因此默认two为n
        for (int i = 0; i < two; ) {
            if (nums[i] == 1) ++i;
            else if (nums[i] == 2) swap(i,--two,nums);
            else if (nums[i] == 0) swap(i++,++zero,nums);
        }
    }
    private void swap(int x,int y, int[] nums) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}
