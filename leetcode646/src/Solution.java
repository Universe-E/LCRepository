import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int findLongestChain(int[][] pairs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        pq.addAll(Arrays.asList(pairs));
        int value = pq.poll()[1];
        int res = 1;
        while (!pq.isEmpty()) {
            int[] curPair = pq.poll();
            if (curPair[0] > value) {
                res++;
                value = curPair[1];
            }
        }
        return res;
    }
}
class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length,tail = -1001,res = 0;
        Arrays.sort(pairs,Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i < n; i++) {
            if (pairs[i][0] > tail) {
                res++;
                tail = pairs[i][1];
            }
        }
        return res;
    }
}