class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        int[] pre = new int[n], suf = new int[n];
        pre[0] = stations[0];
        suf[n-1] = stations[n-1];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1] + stations[i];
            suf[n-i-1] = suf[n-i] + stations[n-i];
        }
        long res = Long.MAX_VALUE;
        

    }
}