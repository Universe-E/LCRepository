import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int value : arr) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> (o2[1]-o1[1]));
        for (Integer key : map.keySet()) {
            pq.add(new int[] {key,map.get(key)});
        }
        int sum = 0,res = 0;
        while (!pq.isEmpty() && sum < n/2) {
            sum += pq.poll()[1];
            res++;
        }
        return res;
    }
}