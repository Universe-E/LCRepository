class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int op = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (nums[i] % 2 != 0) {
                    nums[i]--;
                    op++;
                }
            }
            if (check(nums)) break;
            if (isAllEven(nums)) {
                for (int i = 0; i < n; i++) nums[i] /= 2;
                op++;
            }
        }
        return op;
    }

    private boolean check(int[] nums) {
        for (int num : nums) if (num != 0) return false;
        return true;
    }

    private boolean isAllEven(int[] nums) {
        for (int num : nums) if (num % 2 != 0) return false;
        return true;
    }
}