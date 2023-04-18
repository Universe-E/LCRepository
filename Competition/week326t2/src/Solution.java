import java.util.HashSet;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int distinctPrimeFactors(int[] nums) {
        for (int num : nums) {
            getZ(num);
        }
        return set.size();
    }
    private void getZ(int n) {
        int m = 2;
        while (n != 1) {
            while (n % m == 0) {
                n /= m;
                set.add(m);
            }
            m++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,4,8,16};
        System.out.println(new Solution().distinctPrimeFactors(nums));
    }

}