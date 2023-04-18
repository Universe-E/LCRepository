import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        Integer[] idxs = new Integer[n];
        ArrayList<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            idxs[i] = i;
        }
        for (int[] road : roads) {
            int x = road[0], y = road[1];
            g[x].add(y);
            g[y].add(x);
        }
        //sort the idxs array by the size of g[idx] decrease
        Arrays.sort(idxs, (o1,o2) -> (g[o2].size() - g[o1].size()));
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long)g[idxs[i]].size() * (n-i);
        }
        return res;
    }
}