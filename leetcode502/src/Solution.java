import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = profits[i];
            arr[i][2] = capital[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(o->o[2]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> (o2-o1));
        int i = 0;
        while (k > 0) {
            while (i < n && arr[i][2] <= w) {
                pq.add(arr[i][1]);
                i++;
            }
            if (!pq.isEmpty()) w += pq.poll();
            k--;
        }
        return w;
    }
}