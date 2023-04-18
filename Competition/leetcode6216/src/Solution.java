import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new long[] {nums[i],cost[i]};
        }
        Arrays.sort(arr, Comparator.comparingLong(o -> o[0]));
        //从最小的数找到最大的数，所有数字单次操作的cost和记为sumCost
        long sumCost = 0,total = 0;
        //初始的total默认在最小值处
        for (int i = 0; i < n; i++) {
            sumCost += arr[i][1];
            total += (arr[i][0] - arr[0][0]) * arr[i][1];
        }
        long res = total;
        for (int i = 1; i < n; i++) {
            //从arr[i-1][0]上升到arr[i][0]时，总消耗变为sumCost - 2*arr[i-1][1]
            sumCost -= 2 * arr[i-1][1];
            total -= sumCost * (arr[i][0] - arr[i-1][0]);
            res = Math.min(res,total);
        }
        return res;
    }
}