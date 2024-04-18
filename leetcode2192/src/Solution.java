import java.util.*;

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g,e->new ArrayList<>());
        int[] ind = new int[n];
        boolean[] v = new boolean[n];
        for (int[] e : edges) {
            int x = e[0],y = e[1];
            g[x].add(y);
            ind[y]++;
        }
        HashSet<Integer>[] sets = new HashSet[n];
        Arrays.setAll(sets,e->new HashSet<>());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (ind[i] == 0) {
                q.addLast(i);
                v[i] = true;
            }
        }
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                assert !q.isEmpty();
                int x = q.pollFirst();
                for (Integer y : g[x]) {
                    ind[y]--;
                    sets[y].add(x);
                    for (Integer x2 : sets[x]) {
                        sets[y].add(x2);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (ind[i] == 0 && !v[i]) {
                    q.addLast(i);
                    v[i] = true;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (HashSet<Integer> set : sets) {
            List<Integer> cur = new ArrayList<>(set);
            Collections.sort(cur);
            res.add(cur);
        }
        return res;
    }
}