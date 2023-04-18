import java.util.PriorityQueue;

class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> (o2-o1));
        for (int i : amount) {
            pq.offer(i);
        }
        int cnt = 0;
        while (pq.peek() != 0) {
            int c1 = pq.poll(), c2 = pq.peek()==0 ? 0 : pq.poll();
            pq.add(--c1);
            if (c2 != 0) pq.add(--c2);
            cnt++;
        }
        return cnt;
    }
}
