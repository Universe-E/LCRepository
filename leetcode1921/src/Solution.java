import java.util.Arrays;

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = dist[i]/speed[i] + (dist[i]%speed[i] == 0 ? 0 : 1);
        }
        Arrays.sort(time);
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (i >= time[i]) break;
            res++;
        }
        return res;
    }
}