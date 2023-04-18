import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        //idx按照difficulty从小到大排序
        Arrays.sort(idx, Comparator.comparingInt(o->difficulty[o]));
        int cur = 0;
        //将profit[i]的值修改为当前difficulty[i]难度下能获得的最大利润
        for (int i = 0; i < n; i++) {
            cur = Math.max(cur,profit[idx[i]]);
            profit[idx[i]] = cur;
        }
        int res = 0;
        for (int w : worker) {
            //如果最低难度都无法胜任，则直接跳过该工人
            if (difficulty[idx[0]] > w) continue;
            //每次二分查找小于w的最大值difficulty，即对应当前w能获得的最大收益
            int l = 0, r = n-1;
            while (l < r) {
                int m = l + (r-l+1)/2;
                if (difficulty[idx[m]] > w) r = m-1;
                else l = m;
            }
            res += profit[idx[l]];
        }
        return res;
    }
}