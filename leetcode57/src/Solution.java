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

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            // 在插入区间的右侧且无交集
            if (interval[0] > right) {
                //此时代表第一个
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            }
            // 在插入区间的左侧且无交集
            else if (interval[1] < left) {
                ansList.add(interval);
            }
            // 与插入区间有交集，计算它们的并集
            else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
