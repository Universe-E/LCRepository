class Solution {
    int[] res;
    int x;
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        res = new int[n-k+1];
        this.x = x;
        int[] cnt = new int[101];
        for (int i = 0; i < k; i++) {
            cnt[nums[i]+50]++;
        }
        work(0,cnt);
        for (int i = 1; i < n - k + 1; i++) {
            cnt[nums[i-1]+50]--;
            cnt[nums[i+k-1]+50]++;
            work(i,cnt);
        }
        return res;
    }

    private void work(int idx,int[] cnt) {
        int count = 0;
        for (int i = 0; i <= 100; i++) {
            if (cnt[i] == 0) continue;
            if (count < x) count += cnt[i];
            if (count >= x) {
                res[idx] = Math.min(i-50,0);
                break;
            }
        }
    }
}