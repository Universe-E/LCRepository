import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        //sort by x start
        Arrays.sort(points, Comparator.comparingInt(o->o[1]));
        int res = 0;
        for (int i = 0; i < n;) {
            int r = points[i][1];
            i++;
            while (i < n && points[i][0] <= r) i++;//只要重合就继续跟进
            res++;//来一箭
        }
        return res;
    }
}