import java.util.PriorityQueue;

class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>((d1,d2) -> Double.compare(d2,d1));
        double sum = 0;
        for (int num : nums) {
            sum += num;
            pq.add((double) num);
        }
        double sub = 0;
        int res = 0;
        while (sub < sum / 2) {
            double d = pq.poll();
            sub += d / 2;
            d /= 2;
            pq.add(d);
            res++;
        }
        return res;
    }
}
