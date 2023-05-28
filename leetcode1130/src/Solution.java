import java.util.Arrays;

class Solution {
    long[][] memo;
    int[][] maxs;
    int[] arr;
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        memo = new long[n][n];
        maxs = new int[n][n];
        this.arr = arr;
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i],Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            maxs[i][i] = arr[i];
            for (int j = i+1; j < n; j++) {
                maxs[i][j] = Math.max(maxs[i][j-1],arr[j]);
            }
        }
        return (int) dfs(0,n-1);
    }

    private long dfs(int l,int r) {
        if (l == r) return memo[l][r] = 0;//非叶子节点，默认为0
        if (l+1 == r) return memo[l][r] = (long) arr[l]*arr[r];
        if (memo[l][r] != Integer.MAX_VALUE) return memo[l][r];
        //大于2个叶子节点的情况
        for (int i = l; i < r; i++) {
            int lMax = maxs[l][i],rMax = maxs[i+1][r];
            memo[l][r] = Math.min(memo[l][r],dfs(l,i)+dfs(i+1,r)+(long) lMax*rMax);
        }
        return memo[l][r];
    }
}