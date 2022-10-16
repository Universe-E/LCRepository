import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o2 - x) == Math.abs(o1 - x)) return o1 - o2;
            return Math.abs(o1 - x) - Math.abs(o2 - x);
        });
        for (int value : arr) pq.add(value);
        for (int i = 0; i < k; i++) list.add(pq.poll());
        Collections.sort(list);
        return list;
    }
}

class Solution2 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>(),res = new ArrayList<>();
        for (int value : arr) list.add(value);
        list.sort((o1, o2) -> (Math.abs(o1 - x) == Math.abs(o2 - x) ? o1 - o2 : Math.abs(o1 - x) - Math.abs(o2 - x)));
        for (int i = 0; i < k; i++) res.add(list.get(i));
        Collections.sort(res);
        return res;
    }
}
