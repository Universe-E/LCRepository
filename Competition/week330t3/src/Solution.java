import java.util.PriorityQueue;

class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(), pq2 = new PriorityQueue<>((o1,o2) -> (o2-o1));
        for (int i = 1; i < n; i++) {
            pq1.add(weights[i]+weights[i-1]);
            pq2.add(weights[i]+weights[i-1]);
        }
        long max = 0,min = 0;
        for (int i = 0; i < k - 1; i++) {
            min += pq1.poll();
            max += pq2.poll();
        }
        return max-min;
    }
}