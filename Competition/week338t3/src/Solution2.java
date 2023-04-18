import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        List<Long> list = new ArrayList<>();
        Arrays.sort(nums);
        long[] preSum = new long[n+1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        for (int query : queries) {
            int hi, lo;
            if (query > nums[n-1])
                hi = n;
            else {
                int l1 = 0, r1 = n-1;
                while (l1 < r1) {
                    int m = (l1+r1) / 2;
                    if (nums[m] < query)
                        l1 = m+1;
                    else
                        r1 = m;
                }
                hi = l1;
            }
            if (query < nums[0])
                lo = -1;
            else {
                int l2 = 0, r2 = n-1;
                while (l2 < r2) {
                    int m = (l2+r2+1) / 2;
                    if (nums[m] > query)
                        r2 = m-1;
                    else
                        l2 = m;
                }
                lo = l2;
            }
            list.add(preSum[n]-preSum[lo+1] - (long)(n-lo-1)*query + (long)hi*query - (preSum[hi]-preSum[0]));
        }
        return list;
    }
}