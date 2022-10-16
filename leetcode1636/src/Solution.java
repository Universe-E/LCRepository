import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) return o2[0] - o1[0];
            return o1[1] - o2[1];
        });
        for (Integer key : map.keySet()) {
            int[] cur = new int[] {key,map.get(key)};
            pq.add(cur);
        }
        int[] res = new int[nums.length];
        int i = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int key = cur[0],value = cur[1];
            while (value != 0) {
                res[i] = key;
                i++;
                value--;
            }
        }
        return res;
    }
}