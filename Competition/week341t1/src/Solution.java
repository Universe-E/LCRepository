class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int id = -1,res = -1;
        for (int i = 0; i < m; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) cur++;
            }
            if (cur > res) {
                res = cur;
                id = i;
            }
        }
        return new int[] {id,res};
    }
}