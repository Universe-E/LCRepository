class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] pre = new int[n+1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i-1] + nums[i-1];
        }
        int max = 0;
        for (int i = firstLen; i <= n-secondLen; i++) {
            for (int j = i; j <= n-secondLen; j++) {
                max = Math.max(max,pre[i] - pre[i-firstLen] + pre[j+secondLen] - pre[j]);
            }
        }
        for (int i = secondLen; i <= n-firstLen; i++) {
            for (int j = i; j <= n-firstLen; j++) {
                max = Math.max(max,pre[i] - pre[i-secondLen] + pre[j+firstLen] - pre[j]);
            }
        }
        return max;
    }
}

class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(help(nums,firstLen,secondLen),help(nums,secondLen,firstLen));
    }

    private int help(int[] nums, int firstLen, int secondLen) {
        int sum1 = 0;
        for (int i = 0; i < firstLen; i++) {
            sum1 += nums[i];
        }
        int lMax = sum1;
        int sum2 = 0;
        for (int i = firstLen; i < firstLen + secondLen; i++) {
            sum2 += nums[i];
        }
        int res = lMax + sum2;
        for (int i = firstLen + secondLen,j = firstLen; i < nums.length; i++,j++) {
            sum1 += nums[j] - nums[j-firstLen];
            lMax = Math.max(lMax,sum1);
            sum2 += nums[i] - nums[i-secondLen];
            res = Math.max(res,lMax+sum2);
        }
        return res;
    }
}