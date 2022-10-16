import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        //根据map对象的值来确定优先顺序
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1,o2) -> o2.getValue() - o1.getValue());
        queue.addAll(entries);


        //从优先队列中取出，并将键放入结果集中
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }


}
