class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int cnt = 0;
        for (int num : nums) {
            if (num == 0) res += ++cnt;
            else cnt = 0;
        }
        return res;
    }
}