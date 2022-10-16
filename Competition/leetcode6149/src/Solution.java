import java.util.HashMap;

class Solution {
    public int edgeScore(int[] edges) {
        HashMap<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!map.containsKey(edges[i])) {
                map.put(edges[i], (long) i);
            }
            else {
                long value = map.get(edges[i]);
                map.put(edges[i], i + value);
            }
        }

        long max = -1;
        int res = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                res = key;
            }
            else if (map.get(key) == max && key < res) {
                res = key;
            }
        }
        return res;
    }
}
