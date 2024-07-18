import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        ArrayList<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g,e->new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1], d = e[2];
            g[x].add(new int[]{y,d});
            g[y].add(new int[]{x,d});
        }
        int[] res = new int[n];
        Arrays.fill(res,-1);
        res[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.add(new int[]{0,0});
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int dx = arr[0], x = arr[1];
            if (dx > res[x]) continue;
            for (int[] e : g[x]) {
                int y = e[0], dy = e[1];
                int dx2 = dx+dy;
                //更新需满足条件：
                //1. y未消失
                //2. y的最短路未更新，或者比现在长
                if (dx2 < disappear[y] && (res[y] < 0 || res[y] > dx2)) {
                    res[y] = dx2;
                    pq.add(new int[]{dx2,y});
                }
            }
        }
        return res;
    }
}