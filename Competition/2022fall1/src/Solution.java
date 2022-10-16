class Solution {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int[] arr = new int[n];
        for (int i = 1; i < n; i++) {
            int a = temperatureA[i] - temperatureA[i - 1], b = temperatureB[i] - temperatureB[i - 1];
            if (a * b > 0 || (a == 0 && b == 0)) arr[i] = 1;
        }
        int res = 0,cur = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) cur++;
            else cur = 0;
            res = Math.max(res,cur);
        }
        return res;
    }
}