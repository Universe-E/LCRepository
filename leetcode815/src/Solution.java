import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        int n = routes.length;
        HashSet<Integer>[] g = new HashSet[n];
        HashSet<Integer>[] sets = new HashSet[n];
        Arrays.setAll(g,e->new HashSet<>());
        Arrays.setAll(sets,e->new HashSet<>());
        for (int i = 0; i < n; i++) {
            for (int route : routes[i]) {
                sets[i].add(route);
            }
        }
        for (int i = 0; i < n; i++) {
            for (Integer station : sets[i]) {
                for (int j = i+1; j < n; j++) {
                    //bus line i and j are connected
                    if (sets[j].contains(station)) {
                        g[i].add(j);
                        g[j].add(i);
                    }
                }
            }
        }
        //bfs
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[] v = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (sets[i].contains(source)) {
                q.addLast(new int[]{i,1});
                v[i] = true;
            }
        }
        while (!q.isEmpty()){
            int[] a = q.pollFirst();
            if (sets[a[0]].contains(target)) return a[1];
            for (Integer station : g[a[0]]) {
                if (v[station]) continue;
                q.addLast(new int[]{station,a[1]+1});
                v[station] = true;
            }
        }
        return -1;
    }
}