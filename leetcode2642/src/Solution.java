import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Graph {
    int[][] memo,g;
    public static final int inf = 0x3f3f3f3f;
    int n;
    public Graph(int n, int[][] edges) {
        memo = new int[n][n];
        g = new int[n][n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i],inf);
            Arrays.fill(g[i],inf);
            memo[i][i] = 0;
        }
        for (int[] e : edges) {
            g[e[0]][e[1]] = e[2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != inf) memo[i][j] = g[i][j];
            }
        }
        //floyd
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    memo[i][j] = Math.min(memo[i][j],memo[i][k]+memo[k][j]);
                }
            }
        }
    }

    public void addEdge(int[] edge) {
        int x = edge[0], y = edge[1], k = edge[2];
        memo[x][y] = Math.min(memo[x][y],k);
        for (int i = 0; i < n; i++) {
            memo[x][i] = Math.min(memo[x][i],memo[y][i] + k);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = Math.min(memo[i][j],memo[i][x]+memo[x][j]);
            }
        }
    }

    public int shortestPath(int node1, int node2) {
        return memo[node1][node2] == inf ? -1 : memo[node1][node2];
    }
}