import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        ArrayList<Integer>[] xs = new ArrayList[101];
        for (int i = 0; i < 101; i++) {
            xs[i] = new ArrayList<>();
        }
        for (int[] r : rectangles) {
            xs[r[1]].add(r[0]);
        }
        for (int i = 0; i < 101; i++) {
            Collections.sort(xs[i]);
        }
        int n = points.length;
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            int xi = points[i][0],yi = points[i][1];
            for (int j = yi; j < 101; j++) {
                if (xs[j].isEmpty()) continue;
                //二分查找大于等于xi的最小索引
                int l = 0,r = xs[j].size()-1;
                while (l < r) {
                    int m = (l+r)/2;
                    if (xs[j].get(m) >= xi) r = m;
                    else l = m+1;
                }
                cnt[i] += xs[j].get(l) < xi ? 0 : (l+1);
            }
        }
        return cnt;
    }
}