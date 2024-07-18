class Solution {
    public int findTheWinner(int n, int k) {
        if (k == 1) return n;
        boolean[] v = new boolean[n+1];
        int cnt = 0, i = 1, cur = 1;
        while (cnt != n-1) {
            if (v[i]) {
                i = (i+1)%n + 1;
                continue;
            }
            else cur++;
            if (cur == k) {
                v[i] = true;
                cnt++;
                cur = 0;
            }
            i = (i+1)%n + 1;
        }
        return i;
    }
}