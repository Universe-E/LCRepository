import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] res = new int[1][];
            res[0] = newInterval;
            return res;
        }
        List<int[]> list = new ArrayList<>();
        Collections.addAll(list,intervals);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] >= newInterval[0]) {
                list.add(i,newInterval);
                break;
            }
            if (i == list.size() - 1 && list.get(i)[0] < newInterval[0]) {
                list.add(list.size(),newInterval);
                break;
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i)[1] >= list.get(i + 1)[0]) {
                list.set(i,new int[] {list.get(i)[0],Math.max(list.get(i)[1],list.get(i + 1)[1])});
                list.remove(i + 1);
                i--;
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }
}
