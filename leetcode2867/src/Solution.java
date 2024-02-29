import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private static final boolean[] p = new boolean[100001];
    static {
        Arrays.fill(p,true);
        p[0] = p[1] = false;
        for (int i = 2; i*i <= 100000; i++) {
            if (p[i]) {
                for (int j = i*i; j <= 100000; j+=i) {
                    p[j] = false;
                }
            }
        }
    }
    public long countPaths(int n, int[][] edges) {
        ArrayList<Integer>[] g = new ArrayList[n+1];
        Arrays.setAll(g,e->new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0],y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        List<Integer> seen = new ArrayList<>();
        long res = 0;
        long[] cnt = new long[n+1];
        for (int i = 1; i <= n; i++) {
            if (!p[i]) continue;
            long cur = 0;
            for (Integer j : g[i]) {
                if (p[j]) continue;
                if (cnt[j] == 0) {
                    seen.clear();
                    dfs(g,seen,j,0);
                    long curCnt = seen.size();
                    for (Integer k : seen) {
                        cnt[k] = curCnt;
                    }
                }
                res += cnt[j] * cur;
                cur += cnt[j];
            }
            res += cur;
        }
        return res;
    }

    private void dfs(ArrayList<Integer>[] g, List<Integer> seen, Integer j, int pre) {
        seen.add(j);
        for (Integer y : g[j]) {
            if (y != pre && !p[y]) dfs(g,seen,y,j);
        }
    }
}