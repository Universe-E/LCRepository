class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] valid = new boolean[m][n];
        int[] d = new int[] {-1,0,1,0,-1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && (i == 0 || i == m-1 || j == 0 || j == n-1)) {
                    valid[i][j] = true;
                    //将与之相连的所有非边界O全部置为true
                    dfs(board,valid,i,j,d,true);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !valid[i][j]) board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, boolean[][] valid, int i, int j, int[] d, boolean start) {
        int m = board.length,n = board[0].length;
        //三种情况返回：
        //1、在边界上（或者越界，但除去起始点）
        //2、不是O
        //3、是O但已经被标记
        if (!start && (i <= 0 || i >= m-1 || j <= 0 || j >= n-1 || board[i][j] == 'X' || valid[i][j])) return;
        valid[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int cx = i + d[k], cy = j + d[k+1];
            dfs(board,valid,cx,cy,d,false);
        }
    }
}