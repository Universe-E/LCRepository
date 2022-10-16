class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(board[i], 0, temp[i], 0, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int k = Math.max(0,i - 1); k <= Math.min(m - 1,i + 1); k++) {
                    for (int l = Math.max(0,j - 1); l <= Math.min(n - 1,j + 1); l++) {
                        if (k == i && l == j) continue;
                        if (temp[k][l] == 1) count++;
                    }
                }
                if (temp[i][j] == 1) {
                    if (count < 2 || count > 3) board[i][j] = 0;
                }
                else {
                    if (count == 3) board[i][j] = 1;
                }
            }
        }
    }
}