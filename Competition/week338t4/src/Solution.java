import java.util.ArrayList;

class Solution {
    ArrayList<Integer>[] g;
    ArrayList<Integer> cl;
    int[] depth;
    boolean[] v;
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        g = new ArrayList[n];
        cl = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            if (coins[i] == 1) cl.add(i);
        }
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        depth = new int[n];
        v = new boolean[n];
        dfs(0,0);
        

    }

    private void dfs(int x,int d) {
        if (v[x]) return;
        v[x] = true;
        depth[x] = d;
        for (Integer i : g[x]) {
            dfs(i,d+1);
        }
    }

}