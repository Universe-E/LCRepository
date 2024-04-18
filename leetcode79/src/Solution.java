class Solution {
    int m,n;
    boolean[][] v;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        v = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board,i,j,0,word)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,int i,int j,int cur,String word) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(cur) || v[i][j]) return false;
        if (cur == word.length()-1) return true;
        v[i][j] = true;
        boolean b = dfs(board,i+1,j,cur+1,word) || dfs(board,i-1,j,cur+1,word)
                || dfs(board,i,j+1,cur+1,word) || dfs(board,i,j-1,cur+1,word);
        v[i][j] = false;
        return b;
    }
}