import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int[] match : matches) {
            map.put(match[0],map.getOrDefault(match[0],0));
            map.put(match[1],map.getOrDefault(match[1],0)+1);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>(),l2 = new ArrayList<>();
        for (Integer k : map.keySet()) {
            if (map.get(k) == 0) l1.add(k);
            if (map.get(k) == 1) l2.add(k);
        }
        Collections.sort(l1);
        Collections.sort(l2);
        res.add(l1);
        res.add(l2);
        return res;
    }
}