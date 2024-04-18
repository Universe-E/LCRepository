class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] in = new int[n];
        for (int[] e : edges) {
            in[e[1]]++;
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                if (res != -1) return -1;
                res = i;
            }
        }
        return res;
    }
}