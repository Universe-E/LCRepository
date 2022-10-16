import java.util.Arrays;

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        //dp[i]是第i位能采摘的最大数量
        int[] dp = new int[n];
        //每种水果都可以至少被采摘一次，因此初始值全为1
        Arrays.fill(dp, 1);
        //分别记录首末两种篮子里的水果种类
        int start = fruits[0], end = fruits[0];
        //初始end和start相同，未被修改过，这里声明modified为false
        boolean modified = false;
        for (int i = 1; i < n; i++) {
            //如果遇到end篮子的种类和start篮子里的不同，则修改end为最新值
            if (!modified && fruits[i] != end) {
                end = fruits[i];
                modified = true;
            }
            //如果水果满足两种条件之一，则继续采摘
            if (fruits[i] == start || fruits[i] == end) dp[i] = dp[i - 1] + 1;
            //如果不满足：
            //1、将前一个水果的种类作为新的start（因为当前水果fruits[i]的种类必定与fruits[i - 1]不同）
            //2、滑动窗口，从新的start向左边继续寻找，直到遇到fruits[j]和start不同为止
            //此时的j作为当前dp[i]的“起始点”，因此dp[i] = i - j
            //3、将当前水果作为end篮子，继续向后寻找
            else if (fruits[i] != start && fruits[i] != end) {
                start = fruits[i - 1];
                int j = i - 1;
                while (j >= 0 && fruits[j] == start) j--;
                dp[i] = i - j;
                end = fruits[i];
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}