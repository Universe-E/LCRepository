import java.util.TreeSet;

class Solution {
    //遍历三个边界：上下右，用二分法查找左边界，可以降低到m^2 * n * log n
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        //求前缀和，即dp[i][j]是matrix[0][0]到matrix[i-1][j-1]矩形的和
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int top = 1; top < m + 1; top++) {
            for (int bottom = top; bottom < m + 1; bottom++) {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                for (int right = 1; right < n + 1; right++) {
                    //先确定上下右三个边界
                    //找到以top - 1、bottom、right为上下边界的前缀和为r
                    int r = dp[bottom][right] - dp[top - 1][right];
                    //找面积小于等于k的最大值，即找大于等于r - k面积的最小前缀和记为l
                    Integer l = ts.ceiling(r - k);
                    if (l != null) res = Math.max(res,r - l);
                    ts.add(r);
                }
            }
        }
        return res;
    }
}