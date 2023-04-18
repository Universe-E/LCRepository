import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        //预处理前缀和和后缀和，注意要加一位0
        int[] pre = new int[n+1], suf = new int[n+1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i-1] + nums[i-1];
            suf[n-i] = suf[n-i+1] + nums[n-i];
        }
        int res = n+1;
        for (int i = 0; i <= n && pre[i] <= x; i++) {
            //设定一个pre[i]，然后去找令suf[i] = x - pre[i]的坐标
            int l = i, r = n, target = x - pre[i];
            while (l <= r) {
                int mid = (l + r) / 2;
                if (suf[mid] == target) res = Math.min(res,i+n-mid);
                if (suf[mid] > target) l = mid + 1;
                else r = mid - 1;

            }
        }
        return res == (n+1) ? -1 : res;
    }
}

class Solution2 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum < x) return -1;
        int r = 0, lSum = 0, rSum = sum;
        int res = n+1;
        for (int i = -1; i < n; i++) {
            if (i >= 0) lSum += nums[i];
            //滑动窗口，直到lSum + rSum <= x为止
            while (r < n && lSum + rSum > x) {
                rSum -= nums[r];
                r++;
            }
            if (lSum + rSum == x) res = Math.min(res,i+1+n-r);
        }
        return res == (n+1) ? -1 : res;
    }
}