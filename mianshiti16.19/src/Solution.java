import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    private static final int[][] d2 = new int[][] {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
    private boolean inArea(int i,int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
    int n,m;
    public int[] pondSizes(int[][] land) {
        n = land.length;
        m = land[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 0) list.add(fill(land,i,j));
            }
        }
        Collections.sort(list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int fill(int[][] land,int i, int j) {
        var q = new ArrayDeque<int[]>();
        q.addLast(new int[]{i,j});
        int cnt = 1;
        land[i][j] = -1;
        while (!q.isEmpty()) {
            var c = q.pollFirst();
            for (int k = 0; k < 8; k++) {
                int cx = c[0]+d2[k][0],cy = c[1]+d2[k][1];
                if (inArea(cx,cy) && land[cx][cy] == 0) {
                    q.addLast(new int[]{cx,cy});
                    land[cx][cy] = -1;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}