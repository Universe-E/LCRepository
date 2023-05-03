import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static final int inf = 0x3f3f3f3f;
    ArrayList<Integer> list;
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        ArrayList<Integer> list = new ArrayList<>();
        int prev = -1;
        for (int num : arr2) {
            if (num != prev) {
                list.add(num);
                prev = num;
            }
        }
        this.list = list;
        int n = arr1.length,m = list.size();
        //设dp[i][j] 表示数组arr1中的前i个元素进行了j次替换后组成严格递增子数组末尾元素的最小值
        //arr1[i]分2种情况，保留或替换
        //如果保留，则严格大于前i-1个元素替换后组成的子数组的末尾元素，设为dp[i-1][j]，则arr1[i] > dp[i-1][j]
        //如果替换，则替换后的元素严格大于前i-1个元素替换后组成的子数组的末尾元素，设为dp[i-1][j-1]，在arr2中找到大于该元素的最小值
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i],inf);
        }
        dp[0][0] = -1;
        for (int i = 1; i <= n; i++) {
            //替换次数不会大于i
            for (int j = 0; j <= i; j++) {
                //不替换的情况
                if (arr1[i-1] > dp[i-1][j]) dp[i][j] = arr1[i-1];
                //替换的情况
                if (j > 0 && dp[i-1][j-1] != inf) {
                    int idx = bs_high(dp[i-1][j-1]);
                    //找到该元素，dp[i][j]取两种情况的最小值
                    if (list.get(idx) > dp[i-1][j-1])
                        dp[i][j] = Math.min(dp[i][j],list.get(idx));
                }
                //此时说明用j次替换数组可行
                if (i == n && dp[i][j] != inf) return j;
            }
        }
        return -1;

    }

    private int bs_high(int t) {
        int l = 0,r = list.size()-1;
        while (l < r) {
            int m = (l+r)/2;
            if (list.get(m) > t) r = m;
            else l = m+1;
        }
        return l;
    }
}