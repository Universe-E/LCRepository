import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(o1,o2) -> (o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0]));
        int res = 0, end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            //如果发生覆盖，每次保留尾部最近的一个元素
            if (intervals[i][0] < end) {
                res++;
                end = Math.min(end,intervals[i][1]);
            }
            else end = intervals[i][1];
        }
        return res;
    }
}