import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    ArrayList<Integer>[] g;
    int n;
    int[] d;
    public int findShortestCycle(int n, int[][] edges) {
        this.n = n;
        g = new ArrayList[n];
        d = new int[n];
        Arrays.setAll(g,e -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        int res = 1001;
        for (int i = 0; i < n; i++) {
            int r = bfs(i);
            if (r != -1) res = Math.min(res,r);
        }
        return res == 1001 ? -1 : res;

    }

    //注意不能用Stack，要bfs，否则
    private int bfs(int x) {
        int res = 1001;
        Arrays.fill(d,-1);
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{x,-1});
        d[x] = 0;
        while (!q.isEmpty()) {
            int[] arr = q.pollFirst();
            //fa是cur的“祖先”，默认-1
            int cur = arr[0], fa = arr[1];
            for (Integer y : g[cur]) {
                if (d[y] == -1) {
                    //cur是y的“祖先”
                    q.addLast(new int[] {y,cur});
                    d[y] = d[cur]+1;
                }
                else {
                    //如果这个y不是“祖先”，且之前访问过，说明有环
                    if (y != fa) res = Math.min(res,d[y]+d[cur]+1);
                }
            }
        }
        //无环
        return res == 1001 ? -1 : res;
    }
}