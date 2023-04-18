import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res = 0,mid = nums[nums.length / 2];
        for (int num : nums) {
            res += Math.abs(num - mid);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(1343&1024);
    }
}