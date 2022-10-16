import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] downs = new int[n],ups = new int[n];//声明当前天（不含）之前连续非递增的天数和之后连续非递减的天数
        Arrays.fill(downs, 0);
        Arrays.fill(ups,0);
        //顺序遍历每一天之前非递增的天数
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) downs[i] = downs[i - 1] + 1;
        }
        //倒序遍历每一天之后非递减的天数
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) ups[i] = ups[i + 1] + 1;
        }
        //接下来遍历同时满足条件的索引
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (downs[i] >= time && ups[i] >= time) list.add(i);
        }
        return list;

    }
}