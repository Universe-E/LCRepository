import java.util.ArrayDeque;

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = n-1; i >= 0; i--) {
            int cur = 0;
            while (!q.isEmpty() && heights[i] > heights[q.peekLast()]) {
                q.pollLast();
                cur++;
            }
            if (q.isEmpty()) res[i] = cur;
            else res[i] = cur+1;
            q.addLast(i);
        }
        return res;
    }
}