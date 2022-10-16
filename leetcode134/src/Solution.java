import java.util.Arrays;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = gas[i] - cost[i];
        }
        //问题转化为，找能够使diff数组前缀和始终为正的i（这里的"前缀"是从i开始到i-1）
        int sum = Arrays.stream(diff).sum();
        if (sum < 0) return -1;
        //接下来求diff数组前缀和，找到最小点，这里表示的是从i=0出发的结果
        int pre = 0,min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i == 0) pre = diff[i];
            else pre += diff[i];
            if (pre <= min) min = pre;
        }
        //如果最小的前缀和都比0大，直接返回0
        if (min >= 0) return 0;
        //接下来遍历数组，让最小点大于0
        for (int i = 1; i < n; i++) {
            min -= diff[i-1];
            if (min >= 0) return i;
        }
        return -1;
    }
}

