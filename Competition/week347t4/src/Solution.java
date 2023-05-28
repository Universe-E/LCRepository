import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int maxIncreasingCells(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(new int[]{mat[i][j],i,j,i*m+j});
            }
        }
        int[] pre = new int[m*n];
        Arrays.fill(pre, 1);
        int res = 1;
        int[] st = pq.poll();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (isAlign(st,cur) && cur[0] > st[0]) {
                pre[cur[3]] += pre[st[3]];
                st = cur;
            }
        }
        for (int j : pre) {
            res = Math.max(res, j);
        }
        return res;
    }

    private boolean isAlign(int[] arr1,int[] arr2) {
        return arr1[1]==arr2[1] || arr1[2]==arr2[2];
    }
}