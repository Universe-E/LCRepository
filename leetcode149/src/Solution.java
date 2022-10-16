import java.util.HashMap;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) return 1;
        HashMap<Double, Integer>[] maps = new HashMap[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            maps[i] = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                double deltaX = points[i][0] - points[j][0];
                double deltaY = points[i][1] - points[j][1];
                double k = deltaX == 0 ? 99999d : deltaY / deltaX;
                maps[i].put(k,maps[i].getOrDefault(k,0) + 1);
            }
            int curMax = 0;
            //斜率最多的点
            for (double k : maps[i].keySet()) {
                curMax = Math.max(curMax,maps[i].get(k));
            }
            res = Math.max(res,curMax);
        }
        return res + 1;
    }
}