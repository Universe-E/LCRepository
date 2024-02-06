import java.util.PriorityQueue;

class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> (o2[0]-o1[0]));
        pq.add(new int[]{nums[0],0});
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            while (i - pq.peek()[1] > k) pq.poll();
            res = pq.peek()[0] + nums[i];
            pq.add(new int[]{res,i});
        }
        return res;
    }
}