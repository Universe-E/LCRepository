import java.util.Arrays;

class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        if (k==0) return Arrays.equals(nums1,nums2) ? 0 : -1;
        long sum1 = 0, sum2 = 0, cnt = 0;
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
            t[i] = nums1[i] - nums2[i];
            if (t[i] != 0 && t[i]%k != 0) return -1;
        }
        if (sum1 != sum2) return -1;
        for (int i = 0; i < n; i++) {
            if (t[i] > 0) cnt += t[i]/k;
        }
        return cnt;
    }
}