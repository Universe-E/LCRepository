import java.util.Arrays;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int res = 0;
        //建邻接矩阵
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                g[i][j] = g[j][i] = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
            }
        }
        //记录V(未加入集合）的点到Vnew（加入集合的点）的最近距离
        int[] lowCost = new int[n];
        Arrays.fill(lowCost,0x3f3f3f3f);
        //点是否加入到了Vnew中，未加入默认为0，加入为1
        int[] v = new int[n];
        //将第0个点加入到Vnew，并更新其他点到0的距离
        v[0] = 1;
        for (int i = 1; i < n; i++) {
            lowCost[i] = g[i][0];
        }
        for (int i = 1; i < n; i++) {
            int id = -1,mn = 0x3f3f3f3f;
            //找到最近的点
            for (int j = 0; j < n; j++) {
                if (v[j] == 0 && lowCost[j] < mn) {
                    id = j;
                    mn = lowCost[j];
                }
            }
            //将最近的点加入Vnew
            v[id] = 1;
            res += mn;
            //更新V中所有点到Vnew的最近距离
            for (int j = 0; j < n; j++) {
                if (v[j] == 0 && g[j][id] < lowCost[j]) {
                    lowCost[j] = g[j][id];
                }
            }
        }
        return res;
    }
}