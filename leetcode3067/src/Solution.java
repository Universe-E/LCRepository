import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    ArrayList<int[]>[] g;
    int n;
    int[] res;
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        n = edges.length+1;
        g = new ArrayList[n];
        res = new int[n];
        Arrays.setAll(g,e->new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1], d = e[2];
            g[x].add(new int[]{y,d});
            g[y].add(new int[]{x,d});
        }
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int[] arr : g[i]) {
                int cnt = dfs(arr[0],i,arr[1],signalSpeed);
                res[i] += cnt * sum;
                sum += cnt;
            }
        }
        return res;
    }

    //统计子树下有多少满足条件的节点
    private int dfs(int x, int fa, int sum, int signalSpeed) {
        int cnt = sum % signalSpeed == 0 ? 1 : 0;
        for (int[] ints : g[x]) {
            int y = ints[0];
            if (y != fa) cnt += dfs(y,x,sum + ints[1],signalSpeed);
        }
        return cnt;
    }
}