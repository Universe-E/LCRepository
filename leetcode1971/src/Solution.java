class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1], g);
        }
        return find(source,g) == find(destination,g);
    }

    private int find(int x, int[] g) {
        if (x != g[x]) g[x] = find(g[x],g);
        return g[x];
    }

    private void union(int x, int y, int[] g) {
        int xF = find(x,g);
        int yF = find(y,g);
        g[yF] = xF;
    }
}