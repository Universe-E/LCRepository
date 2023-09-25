import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        boolean[][] v = new boolean[n][1<<n];
        var q = new ArrayDeque<int[]>();
        for (int i = 0; i < n; i++) {
            //当前节点编号idx,状态mask,长度dist
            q.addLast(new int[]{i,1<<i,0});
            v[i][1<<i] = true;
        }
        while (!q.isEmpty()) {
            int[] a = q.pollFirst();
            int idx = a[0],mask = a[1],dist = a[2];
            //此时已经历所有的节点
            if (mask == (1<<n)-1) return dist;
            for (int y : graph[idx]) {
                int mask2 = mask | (1<<y);
                if (v[y][mask2]) continue;
                q.addLast(new int[] {y,mask2,dist+1});
                v[y][mask2] = true;
            }
        }
        return 0;
    }
}