class Solution {
    public int findKOr(int[] nums, int k) {
        int[] cnt = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1<<i)) != 0) cnt[i]++;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (cnt[i] >= k) res |= (1<<i);
        }
        return res;
    }
}