import java.util.List;

class Solution {
    int n;
    boolean[] v;
    int[] res;
    public int[] countVisitedNodes(List<Integer> edges) {
        n = edges.size();
        res = new int[n];
        v = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (v[i]) continue;
            boolean[] oldV = v.clone();
            int cnt = dfs(i,edges);
            for (int j = 0; j < n; j++) {
                if (oldV[j] != v[j]) res[j] = cnt;
            }
        }
        return res;
    }

    private int dfs(int cur,List<Integer> edges) {
        v[cur] = true;
        int cnt = 1,target = edges.get(cur);
        if (!v[target]) cnt += dfs(target,edges);
        else cnt += res[target];
        return cnt;
    }
}