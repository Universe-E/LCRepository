class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int m = logs.length;
        int p = logs[0][0];
        int longest = logs[0][1];
        for (int i = 1; i < m; i++) {
            int curTime = logs[i][1] - logs[i - 1][1];
            if (curTime > longest) {
                p = logs[i][0];
                longest = curTime;
            }
            if (curTime == longest) {
                p = Math.min(p,logs[i][0]);
            }
        }
        return p;
    }
}