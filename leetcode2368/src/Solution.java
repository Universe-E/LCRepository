import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g,e->new ArrayList<>());
        HashSet<Integer> set = new HashSet<>();
        for (int r : restricted) {
            set.add(r);
        }
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        var q = new ArrayDeque<Integer>();
        int res = 0;
        boolean[] v = new boolean[n];
        q.addLast(0);
        v[0] = true;
        res++;
        while (!q.isEmpty()) {
            int x = q.pollFirst();
            for (Integer y : g[x]) {
                if (set.contains(y) || v[y]) continue;
                q.addLast(y);
                v[y] = true;
                res++;
            }
        }
        return res;
    }
}