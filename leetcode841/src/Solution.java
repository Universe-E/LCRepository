import java.util.ArrayDeque;
import java.util.List;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] v = new boolean[n];
        ArrayDeque<Integer> d = new ArrayDeque<>();
        d.add(0);
        while (!d.isEmpty()) {
            int cur = d.pollFirst();
            if (v[cur]) continue;
            v[cur] = true;
            List<Integer> l = rooms.get(cur);
            for (Integer i : l) {
                if (v[i]) continue;
                d.addLast(i);
            }
        }
        for (boolean b : v) {
            if (!b) return false;
        }
        return true;
    }
}