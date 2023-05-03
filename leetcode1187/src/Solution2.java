import java.util.*;

class Solution {
    static final int INF = 0x3f3f3f3f;
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        List<Integer> list = new ArrayList<Integer>();
        int prev = -1;
        for (int num : arr2) {
            if (num != prev) {
                list.add(num);
                prev = num;
            }
        }
        int[] temp = new int[arr1.length + 2];
        System.arraycopy(arr1, 0, temp, 1, arr1.length);
        //右侧哨兵 inf
        temp[arr1.length + 1] = INF;
        //左侧哨兵 -1
        temp[0] = -1;
        arr1 = temp;
        int n = arr1.length;
        int m = list.size();

        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            /* arr1[i] 左侧的元素不进行替换 */
            if (arr1[i - 1] < arr1[i]) {
                dp[i] = Math.min(dp[i], dp[i - 1]);
            }
            /* 替换 arr1[i] 左边的连续 j 个元素 */
            for (int j = 1; j < i; j++) {
                /* arr2 的最优替换的起点为大于 arr1[i - j - 1] 的最小元素 */
                int k = binarySearch(list, arr1[i - j - 1]);
                /* arr2 的最优替换的终点必须满足小于 arr1[i] */
                if (k + j - 1 < m && list.get(k + j - 1) < arr1[i]) {
                    dp[i] = Math.min(dp[i], dp[i - j - 1] + j);
                }
            }

        }
        return dp[n - 1] == INF ? -1 : dp[n - 1];
    }

    public int binarySearch(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}