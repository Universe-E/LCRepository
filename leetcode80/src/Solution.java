import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count < 2) {
                nums[count] = nums[i];
                count++;
            }
            else if (nums[count - 2] != nums[i]) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,2,3};
        int len = new Solution().removeDuplicates(nums);
        int[] res = Arrays.copyOf(nums, len);
        System.out.println(Arrays.toString(res));

    }
}
