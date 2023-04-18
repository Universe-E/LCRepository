class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int cnt = 0,res = 0x3f3f3f3f;
        for (int divisor : divisors) {
            int cur = 0;
            for (int num : nums) {
                if (num % divisor == 0) cur++;
            }
            if (cur == cnt) {
                if (divisor < res) res = divisor;
            } else if (cur > cnt) {
                cnt = cur;
                res = divisor;
            }
        }
        return res;
    }
}