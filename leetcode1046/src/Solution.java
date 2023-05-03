import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }
        while (!pq.isEmpty() && pq.size() > 1) {
            int first = pq.poll(), second = pq.poll();
            if (first != second) pq.add(Math.abs(first-second));
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}