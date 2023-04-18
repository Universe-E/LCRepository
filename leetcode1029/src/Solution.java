import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2, sum = 0;
        //pq1和pq2分别存储a市和b市
        //如果pq1超量了，则要把多出来的元素往pq2中放，此时sum = sum + cost[1] - cost[0]
        //所以找到pq1中cost[1]-cost[0]最小的即可
        //反之亦然，把pq2多出来的元素往pq1中放，此时sum = sum + cost[0] - cost[1]
        //所以找到pq2中cost[0]-cost[1]最小的即可
        PriorityQueue<int[]> pq1 = new PriorityQueue<>(Comparator.comparingInt(o -> o[1] - o[0]));
        PriorityQueue<int[]> pq2 = new PriorityQueue<>(Comparator.comparingInt(o -> o[0] - o[1]));
        //pq1和pq2先分别存储价格较小的一方
        for (int[] cost : costs) {
            if (cost[0] <= cost[1]) {
                pq1.add(cost);
                sum += cost[0];
            }
            else {
                pq2.add(cost);
                sum += cost[1];
            }
        }
        while (pq1.size() > n) {
            int[] poll = pq1.poll();
            sum = sum + poll[1] - poll[0];
        }
        while (pq2.size() > n) {
            int[] poll = pq2.poll();
            sum = sum + poll[0] - poll[1];
        }
        return sum;
    }
}