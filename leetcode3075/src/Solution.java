import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long res = 0;
        for (int i = happiness.length-1,j = 0; i >= 0 && k > 0; i--,j++,k--) {
            res += Math.max(0,happiness[i]-j);
        }
        return res;
    }
}