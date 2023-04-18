import java.util.ArrayList;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        ArrayList<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] r : roads) {
            int x = r[0], y = r[1];
            g[x].add(y);
            g[y].add(x);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                res = Math.max(res,g[i].size() + g[j].size() - (g[i].contains(j) ? 1 : 0));
            }
        }
        return res;
    }
}