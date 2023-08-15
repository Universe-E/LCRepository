import java.util.Arrays;

class Solution {
    int n;
    public int minimizeMax(int[] nums, int p) {
        n = nums.length;
        Arrays.sort(nums);
        int l = 0,r = nums[n-1]-nums[0];
        while (l < r) {
            int m = (l+r)/2;
            if (ok(nums,m,p)) r = m;
            else l = m+1;
        }
        return l;
    }

    private boolean ok(int[] nums, int m, int p) {
        int cnt = 0;
        boolean choosePre = false;
        for (int i = 1; i < n; i++) {
            if (choosePre) {
                choosePre = false;
                continue;
            }
            if (nums[i]-nums[i-1] <= m) {
                cnt++;
                choosePre = true;
            }
        }
        return cnt >= p;
    }
}