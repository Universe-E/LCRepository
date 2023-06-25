import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        //sort index by nums
        Arrays.sort(idx, Comparator.comparingInt(o->nums[o]));
        //preCost: total operating costs before nums[idx[i]] by 1
        //afterCost: total operating costs after nums[idx[i]] by 1
        //totalCost: All nums become nums[idx[i]]
        long preCost = 0,afterCost = 0,totalCost = 0;
        //initialize situation when i = 0
        for (int i = 1; i < n; i++) {
            afterCost += cost[idx[i]];
            totalCost += (long) (nums[idx[i]]-nums[idx[0]])*cost[idx[i]];
        }
        long res = totalCost;
        for (int i = 1; i < n; i++) {
            long delta = nums[idx[i]]-nums[idx[i-1]];
            preCost += cost[idx[i-1]];
            totalCost = totalCost + delta*(preCost-afterCost);
            afterCost -= cost[idx[i]];
            res = Math.min(res,totalCost);
        }
        return res;
    }
}