import java.util.Arrays;

/**
 * 对于点 0，1，...，n-1构成的多边形三角剖分，考虑点0和n-1，因为总有某个点 j 与点0和n-1构成三角形，
 * 使得原多边形被分成一个三角形和至多两个凸多边形，求解原问题退化成求解两个规模更小的子问题，
 * 即有若 f(0,n-1)表示原问题的解，则存在 j使
 * f(0,n-1) = f(0,j) + f(j,n-1) + A[0]*A[k]*A[n-1]
 */
class Solution {
    int[][] m;
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        m = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(m[i],-1);
        }
        return dfs(values,0,n-1);
    }

    private int dfs(int[] values,int l,int r) {
        //此时构成不了三角形
        if (l+2 > r) return 0;
        //此时恰好构成三角形
        if (l+2 == r) return values[l]*values[l+1]*values[l+2];
        if (m[l][r] != -1) return m[l][r];
        int min = 0x3f3f3f3f;
        for (int i = l+1; i < r; i++) {
            int cur = dfs(values,l,i) + dfs(values,i,r) + values[i]*values[l]*values[r];
            min = Math.min(min,cur);
        }
        m[l][r] = min;
        return min;
    }
}