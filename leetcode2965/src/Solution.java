class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length, a = -1, b = -1;
        boolean[] v = new boolean[n*n+1];
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                int x = ints[j];
                if (v[x]) a = x;
                v[x] = true;
            }
        }
        for (int i = 1; i <= n*n; i++) {
            if (!v[i]) b = i;
        }
        return new int[]{a,b};
    }
}