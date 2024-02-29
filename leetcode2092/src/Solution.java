import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] meeting : meetings) {
            g[meeting[0]].add(new int[]{meeting[1], meeting[2]});
            g[meeting[1]].add(new int[]{meeting[0], meeting[2]});
        }
        List<Integer> res = new ArrayList<>();
        // 按时间排序
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        q.offer(new int[]{0, 0}); q.offer(new int[]{firstPerson, 0});
        boolean[] vis = new boolean[n];
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int v = cur[0], t = cur[1];
            if (vis[v]) continue;
            vis[v] = true;
            res.add(v);
            for (int[] next : g[cur[0]]) {
                int p = next[0], time = next[1];
                if (vis[p] || time < t) continue;
                q.offer(next);
            }
        }
        return res;
    }
}