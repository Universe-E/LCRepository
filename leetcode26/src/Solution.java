import java.util.Arrays;
import java.util.TreeSet;

class Solution {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) set.add(num);
        int[] expected = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            expected[i++] = integer;
        }
        System.out.println(Arrays.toString(expected));
        System.arraycopy(expected,0,nums,0,expected.length);
        return expected.length;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,0,0,0,3,3};
        new Solution().removeDuplicates(nums);
    }
}
