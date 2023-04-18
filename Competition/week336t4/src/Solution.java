import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinimumTime(int[][] tasks) {
        //按结束时间排序
        Arrays.sort(tasks, Comparator.comparingInt(o -> o[1]));
        boolean[] v = new boolean[2001];//记录已经在运行的时间点
        int res = 0;
        for (int[] t : tasks) {
            int s = t[0], e = t[1], d = t[2];
            //先遍历一遍t，如果区间内已经有正在运行的时间点，则将添加到该时间点运行
            for (int i = s; i <= e; ++i) if (v[i]) --d;
            //如果有剩下的运行时间点，则添加到后缀上
            for (int i = e; d > 0; --i) {//可以省略i >= s，因为一定成立
                if (!v[i]) {
                    --d;
                    v[i] = true;
                    ++res;
                }
            }
        }
        return res;
    }
}