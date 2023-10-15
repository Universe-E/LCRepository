import java.util.HashMap;
import java.util.TreeSet;

class Solution {
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> set0 = new TreeSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = rains.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int r = rains[i];
            if (r == 0) set0.add(i);
            else {
                //如果湖泊r又下雨了
                if (map.containsKey(r)) {
                    //找到大于r之前下雨那天的最小晴天，抽水
                    Integer id0 = set0.ceiling(map.get(r));
                    //如果这中间没有晴天，则发生洪水
                    if (id0 == null) return new int[]{};
                    res[id0] = r;
                    set0.remove(id0);
                }
                map.put(r,i);
                res[i] = -1;
            }
        }
        while (!set0.isEmpty()) {
            Integer id0 = set0.pollFirst();
            assert id0 != null;
            res[id0] = id0+1;
        }
        return res;
    }
}