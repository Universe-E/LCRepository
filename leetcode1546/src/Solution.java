import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length, res = 0;
        //pre[i] represents sum[0,i-1](i > 0)
        int[] pre = new int[n+1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i-1] + nums[i-1];
        }
        int l = 0, i = 1, j = 0;
        while (i <= n) {
            while (j < i) {
                if (pre[i] - pre[j] == target) {
                    res++;
                    l = i;
                    break;
                }
                j++;
            }
            j = l;
            i++;
        }
        return res;
    }
}

class Solution2 {
    public int maxNonOverlapping(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        int curSum = 0;
        int res = 0;
        set.add(0);
        for (int num : nums) {
            curSum += num;
            if (set.contains(curSum - target)) {
                // 如果当前段和减去之前某一段和为target，则符合条件，即当前curSum=上次curSum+target
                set.clear();
                set.add(0);
                curSum = 0;
                res++;
            } else {
                // 还未满足条件，保留当前段的和
                set.add(curSum);
            }
        }
        return res;
    }
}