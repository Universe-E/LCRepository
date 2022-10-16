import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        //从最后一层向上寻找最小值
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);
            //对于每一层的元素，找最小值和正下方的值相加
            for (int j = 0; j < cur.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j],dp[i + 1][j + 1]) + cur.get(j);
            }
        }
        return dp[0][0];
    }
}