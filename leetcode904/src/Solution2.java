import java.util.Arrays;

class Solution2 {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int left = fruits[0],right = -1;
        for (int i = 1; i < n; i++) {
            if (right == -1) {
                if (fruits[i] != left) right = fruits[i];
                dp[i] = dp[i-1] + 1;
            }
            else {
                if (fruits[i] == left || fruits[i] == right) dp[i] = dp[i-1] + 1;
                //遇到第三种水果，将前一种水果变成左篮子种类，当前水果变成右篮子种类
                else {
                    left = fruits[i-1];
                    right = fruits[i];
                    //从前一个往左边找到边界
                    int j = i-1;
                    while (j >= 0 && fruits[j] == left) j--;
                    dp[i] = i - j;
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}