import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->(o2-o1));
        long sum = 0;
        for (int g : gifts) {
            pq.add(g);
            sum += g;
        }
        long diff = 0;
        while (k > 0) {
            int t = pq.poll();
            pq.add((int)Math.sqrt(t));
            diff += t-(int)(Math.sqrt(t));
            k--;
        }
        return sum-diff;
    }
}