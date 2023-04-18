import java.util.ArrayList;

class Solution {
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int n = edges.length;
        ArrayList<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);
        }
        
    }
}