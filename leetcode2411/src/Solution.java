class Solution {
    int[] cnt = new int[32];
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] res = new int[n], suf = new int[n];
        suf[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            suf[i] = nums[i]|suf[i+1];
        }
        for (int l = 0,r = 0; l < n;) {
            while (r < n && get() != suf[l]) {
                manage(nums[r++],true);
            }
            res[l] = Math.max(1,r-l);
            manage(nums[l++],false);
        }
        return res;
    }

    private void manage(int v,boolean isAdd) {
        for (int i = 0; i < 32; i++) {
            if ((v & (1<<i)) != 0) {
                if (isAdd) cnt[i]++;
                else cnt[i]--;
            }
        }
    }

    private int get() {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (cnt[i] != 0) res += 1<<i;
        }
        return res;
    }
}