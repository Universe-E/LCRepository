class Solution {
    private int[] p;
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1) return -1;
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (int[] c : connections) {
            union(c[0],c[1]);
        }
        //找到有几组并查集，需要连接的次数 = 并查集组数-1
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] == i) cnt++;
        }
        return cnt-1;
    }

    private int find(int node) {
        if (p[node] == node) return node;
        p[node] = find(p[node]);
        return p[node];
    }

    private void union(int a,int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return;
        p[pa] = pb;
    }
}