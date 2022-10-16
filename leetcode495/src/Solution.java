class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i == timeSeries.length - 1) res += duration;
            else res += Math.min(timeSeries[i + 1] - timeSeries[i],duration);
        }
        return res;
    }
}
