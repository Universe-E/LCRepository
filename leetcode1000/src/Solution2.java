import java.util.Arrays;

public class Solution {
    private int[][][] memo;
    private int[] pre;
    private int k;
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n-1)%(k-1) != 0) return -1;
        memo = new int[n][n][k+1];
        pre = new int[n+1];
        this.k = k;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j],-1);//-1表示未计算
            }
        }
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i-1] + stones[i-1];
        }
        return dfs(0,n-1,1);
    }

    //将[i,j]合并成p堆的最低成本
    private int dfs(int i,int j,int p) {
        if (memo[i][j][p] != -1) return memo[i][j][p];
        if (p == 1) {
            //如果已经是一堆（即i == j），则不必合并
            if (i == j) return memo[i][j][p] = 0;
            //否则从k堆合并过来
            else return memo[i][j][p] = dfs(i,j,k) + pre[j+1]-pre[i];
        }
        int res = 0x3f3f3f3f;
        //枚举分界点，寻找dfs(i,j,p)的最小值
        for (int m = i; m < j; m+=k-1) {
            res = Math.min(res,dfs(i,m,1) + dfs(m+1,j,p-1));
        }
        return memo[i][j][p] = res;
    }
}
