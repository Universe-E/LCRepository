import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    private static final int inf = 0x3f3f3f3f;
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]>[] g = new ArrayList[n+1];
        Arrays.setAll(g,e->new ArrayList<>());
        for (int[] t : times) {
            g[t[0]].add(new int[] {t[1],t[2]});
        }
        //按耗时从大到小排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> (o2[1]-o1[1]));
        int[] memo = new int[n+1];//memo[i]表示从k到i的最短耗时，初始为inf
        Arrays.fill(memo,inf);
        memo[k] = 0;
        pq.add(new int[]{k,0});
        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            int x = a[0],t = a[1];
            //如果当前时间耗时更长，则跳过
            if (t > memo[x]) continue;
            for (int[] a2 : g[x]) {
                int x2 = a2[0],t2 = a2[1];
                //考察从x到x2的时间，如果更短，则更新
                if (memo[x]+t2 < memo[x2]) {
                    memo[x2] = memo[x]+t2;
                    pq.add(new int[]{x2,t2});
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (memo[i] == inf) return -1;//存在没有收到信号的点
            res = Math.max(res,memo[i]);
        }
        return res;
    }
}