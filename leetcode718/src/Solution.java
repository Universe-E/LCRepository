class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int res = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums1[i] != nums2[j]) continue;
                int p1 = i, p2 = j,count = 0;
                while (p1 < n1 && p2 < n2 && nums1[p1] == nums2[p2]) {
                    p1++;
                    p2++;
                    count++;
                }
                res = Math.max(res,count);
            }
        }
        return res;
    }
}

class Solution2 {
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        int res = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}