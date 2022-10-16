import java.util.Arrays;

class Solution2 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        //dp1表示与左侧的分差，dp2表示与右侧的分差
        int[] dp1 = new int[n],dp2 = new int[n];
        for (int i = 1; i < n; i++) dp1[i] = ratings[i] - ratings[i - 1];
        for (int i = n - 2; i >= 0; i--) dp2[i] = ratings[i] - ratings[i + 1];
        int[] candy = new int[n];
        //先将需要置为1的地方置为1
        for (int i = 0; i < n; i++) if (dp1[i] <= 0 && dp2[i] <= 0) candy[i] = 1;
        //随后，分别从左往右和从右往左记录candy中非1元素到左侧（右侧）的距离
        int[] left = new int[n],right = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (candy[i] == 1) left[i] = 1;
            left[i] = dp1[i] > 0 ? left[i - 1] + 1 : Math.max(1,left[i] - 1);
        }
        right[n - 1] = dp1[n - 1] > 0 ? left[n - 1] : 1;
        for (int i = n - 2; i >= 0; i--) {
            if (candy[i] == 1) right[i] = 1;
            if (dp1[i] > 0 && dp2[i] > 0) right[i] = Math.max(right[i + 1] + 1, left[i]);
            else right[i] = dp2[i] > 0 ? right[i + 1] + 1 : left[i];
        }
        return Arrays.stream(right).sum();
    }
}