import java.util.PriorityQueue;

class Solution {
    public int minCost(String colors, int[] neededTime) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = colors.length(),res = 0;
        char curColor = '#';
        for (int i = 0; i < n; i++) {
            char color = colors.charAt(i);
            if (color != curColor) {
                while (pq.size() > 1) {
                    res += pq.poll();
                }
                pq.clear();
            }
            curColor = color;
            pq.add(neededTime[i]);
        }
        while (pq.size() > 1) {
            res += pq.poll();
        }
        return res;
    }
}
class Solution {
    public int minCost(String s, int[] cost) {
        int re = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                if (cost[i - 1] > cost[i]) {
                    re += cost[i];
                    cost[i] = cost[i - 1];
                } else {
                    re += cost[i - 1];
                }
            }
        }
        return re;
    }
}