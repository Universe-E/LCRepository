import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g,e->new ArrayList<>());
        int[] inDeg = new int[n];
        for (int[] r : relations) {
            int a = r[0]-1,b = r[1]-1;
            g[a].add(b);
            inDeg[b]++;
        }
        var q = new ArrayDeque<Integer>();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = time[i];
            if (inDeg[i] == 0) {
                q.addLast(i);
            }
        }
        while (!q.isEmpty()) {
            int x = q.pollFirst();
            for (Integer y : g[x]) {
                inDeg[y]--;
                cost[y] = Math.max(cost[y],cost[x]+time[y]);
                if (inDeg[y] == 0) {
                    q.addLast(y);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res,cost[i]);
        }
        return res;
    }
}