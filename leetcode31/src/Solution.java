import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int p = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                p = i;
                break;
            }
        }
        int l = p + 1;//声明左边界
        //接下来冒泡排序，需要注意不能同向遍历数组
        for (int i = nums.length - 2; i >= l; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        if (p != -1) {//如果p被更新过，则找到排序后第一个比nums[p]大的数字并与之交换
            int p2 = p;
            for (int i = l; i < nums.length; i++) {
                if (nums[i] > nums[p]) {
                    p2 = i;
                    break;
                }
            }
            int temp = nums[p];
            nums[p] = nums[p2];
            nums[p2] = temp;
        }
    }
}
