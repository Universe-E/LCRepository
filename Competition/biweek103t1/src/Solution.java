import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int maximizeSum(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            int cur = pq.poll();
            res += cur;
            pq.add(cur+1);
        }
        return res;
    }
}