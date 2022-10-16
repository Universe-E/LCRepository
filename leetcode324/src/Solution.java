import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        //排序后，偶数位和奇数位从大到小穿插放置，无论数组长度奇偶性，最大位放在1号位
        //1-2-3-4-5-6-7-8    1-2-3-4-5-6-7-8-9  排序后：
        //4-8-3-7-2-6-1-5    5-9-4-8-3-7-2-6-1
        int j = temp.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = temp[j];
            j--;
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = temp[j];
            j--;
        }
    }
}

class Solution2 {
    public void wiggleSort(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        //第二种方法，后一半数组顺序插入前一半数组中
        //1-2-3-4-5-6-7-8  1-2-3-4-5-6-7-8-9  排序后：
        //4-8-3-7-2-6-1-5  5-9-4-8-3-7-2-6-1
        int p = (temp.length + 1) / 2;
        for (int i = 0,j = p - 1; i < nums.length && j >= 0; i += 2,j--) {
            nums[i] = temp[j];
        }
        for (int i = 1,j = nums.length - 1; i < nums.length && j >= p; i += 2,j--) {
            nums[i] = temp[j];
        }
    }
}
