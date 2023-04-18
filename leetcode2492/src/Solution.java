import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<int[]>[] g = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] r : roads) {
            int x = r[0], y = r[1], s = r[2];
            g[x].add(new int[]{y,s});
            g[y].add(new int[]{x,s});
        }
        boolean[] v = new boolean[n+1];
        int res = 10003;
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.add(1);
        while (!ad.isEmpty()) {
            int c = ad.pollFirst();
            if (v[c]) continue;
            v[c] = true;
            for (int[] arr : g[c]) {
                int x = arr[0],s = arr[1];
                if (!v[x]) {
                    ad.addLast(x);
                    res = Math.min(res,s);
                }
            }
        }
        return res;
    }
}