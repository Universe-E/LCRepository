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
                //二分查找小于xi的最大索引
                int yn = xs[j].size(), l = 0,r = yn-1;
                if (xs[j].get(l) >= xi) cnt[i] += yn;
                else {
                    while (l < r) {
                        int m = (l+r+1)/2;
                        if (xs[j].get(m) >= xi) r = m-1;
                        else l = m;
                    }
                    cnt[i] += yn - (l+1);
                }
            }
        }
        return cnt;
    }
}