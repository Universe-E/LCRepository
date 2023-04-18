import java.util.ArrayList;

class Solution {
    ArrayList<Integer>[] g,g2;
    boolean[] v;
    int res = 0;
    public int minReorder(int n, int[][] connections) {
        g = new ArrayList[n];
        g2 = new ArrayList[n];
        v = new boolean[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            g2[i] = new ArrayList<>();
        }
        for (int[] c : connections) {
            int x = c[0], y = c[1];
            g[x].add(y);
            g[y].add(x);
            g2[y].add(x);
        }
        dfs(0);
        return res;
    }
    private void dfs(int x) {
        v[x] = true;
        for (Integer i : g[x]) {
            if (v[i]) continue;
            if (!g2[x].contains(i)) res++;
            dfs(i);
        }
    }
}