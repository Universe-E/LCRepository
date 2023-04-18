import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] cnt = new int[n];
        for (List<Integer> edge : edges) {
           cnt[edge.get(1)]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 0) res.add(i);
        }
        return res;
    }
}