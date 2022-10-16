class Solution {
    public int maximumSwap(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        int[] nums = new int[cs.length];
        for (int i = 0; i < cs.length; i++) {
            nums[i] = cs[i] - '0';
        }
        findAndSwapLargest(nums,0);
        StringBuilder sb = new StringBuilder();
        for (int i : nums) {
            sb.append(i);
        }
        return Integer.parseInt(sb.toString());
    }
    //从左边界l开始处理nums数组
    private void findAndSwapLargest(int[] nums,int l) {
        int max = -1,p = -1;
        //找到数组中最大的一个数的索引，如果有多个最大值且最大值不位于左边界，则取最右边的
        for (int i = l; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                p = i;
            }
        }
        //如果左边界和其他位置同为最大值，则按首位数处理
        if (nums[l] == nums[p]) p = l;
        //如果该数是首位数，则对i = 1后面的数组继续执行相同操作
        if (p == l && nums.length - l != 1){
            findAndSwapLargest(nums,l + 1);
        }
        //如果该数不是首位数，则和首位数交换即为结果
        else {
            int temp = nums[p];
            nums[p] = nums[l];
            nums[l] = temp;
        }
    }
}