import java.util.PriorityQueue;

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> (o2-o1));
        for (int num : nums) {
            pq.add(num);
        }
        long res = 0;
        while (k > 0) {
            int cur = pq.poll();
            res += cur;
            pq.add((cur-1)/3 + 1);
            k--;
        }
        return res;
    }
}