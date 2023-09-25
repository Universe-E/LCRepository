class Solution {
    public int minCapability(int[] nums, int k) {
        int l = 1,r = 0x3f3f3f3f;
        while (l < r) {
            int m = (l+r)/2;
            if (ok(nums,m,k)) r = m;
            else l = m+1;
        }
        return l;
    }

    private boolean ok(int[] nums, int m, int k) {
        int n = nums.length,preId = -1,cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= m) {
                if (preId == -1 || (i-preId > 1)) {
                    preId = i;
                    cnt++;
                }
            }
        }
        return cnt >= k;
    }
}