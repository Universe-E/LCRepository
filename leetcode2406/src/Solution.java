import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals,(o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        //用list逐次遍历会超时，应该用pq，每次只和最小的右边界比较即可
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!pq.isEmpty() && interval[0] > pq.peek()) pq.poll();
            pq.add(interval[1]);
        }
        return pq.size();
    }
}