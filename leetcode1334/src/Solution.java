import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g,e->new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0],y = e[1],d = e[2];
            g[x].add(new int[]{y,d});
            g[y].add(new int[]{x,d});
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[] ds = new int[n];
        int res = -1,cnt = n;
        for (int i = 0; i < n; i++) {
            Arrays.fill(ds,0x3f3f3f3f);
            q.addLast(new int[]{i,0});
            ds[i] = 0;
            //bfs
            while (!q.isEmpty()) {
                int[] arr = q.pollFirst();
                int x= arr[0],dx = arr[1];
                for (int[] yArr : g[x]) {
                    int y = yArr[0],dy = yArr[1];
                    int d = dx+dy;
                    if (d > distanceThreshold || d >= ds[y]) continue;
                    q.addLast(new int[]{y,d});
                    ds[y] = d;
                }
            }
            //calculate
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                if (ds[j] <= distanceThreshold) cur++;
            }
            if (cur <= cnt) {
                cnt = cur;
                res = i;
            }
        }
        return res;
    }
}