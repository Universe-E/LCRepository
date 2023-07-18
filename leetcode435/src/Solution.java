import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        //sort by left, if left are the same, then sort by right
        Arrays.sort(intervals,(o1,o2) -> (o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0]));
        int res = 0, end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            //if overlapped, save the smaller right part
            if (intervals[i][0] < end) {
                res++;
                end = Math.min(end,intervals[i][1]);
            }
            else end = intervals[i][1];
        }
        return res;
    }
}