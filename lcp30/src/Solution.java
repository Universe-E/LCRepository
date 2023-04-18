import java.util.PriorityQueue;

class Solution {
    public int magicTower(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0,cur = 1;
        int res = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < 0) return -1;
        for (int num : nums) {
            cur += num;
            if (num < 0) pq.add(num);
            if (cur <= 0) {
                cur -= pq.poll();
                res++;
            }
        }
        return res;
    }
}