import java.util.Arrays;

class Graph {
    int[][] g,res;
    int n;
    public static final int INF = 0x3f3f3f3f;
    public Graph(int n, int[][] edges) {
        this.n = n;
        g = new int[n][n];
        res = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i],INF);
        }
        for (int[] edge : edges) {
            g[edge[0]][edge[1]] = edge[2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) res[i][j] = 0;
                else if (g[i][j] == INF) res[i][j] = INF;
                else res[i][j] = g[i][j];
            }
        }
        for (int k = 0; k < n; k++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    res[x][y] = Math.min(res[x][y],res[x][k]+res[k][y]);
                }
            }
        }
    }

    public void addEdge(int[] edge) {
        int x = edge[0], y = edge[1], k = edge[2];
        res[x][y] = Math.min(res[x][y],k);
        for (int i = 0; i < n; i++) {
            res[x][i] = Math.min(res[x][i],res[y][i] + k);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = Math.min(res[i][j],res[i][x]+res[x][j]);
            }
        }
    }

    public int shortestPath(int node1, int node2) {
        return res[node1][node2] == INF ? -1 : res[node1][node2];
    }
}