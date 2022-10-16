class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board,visited,i,j,0,word)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,boolean[][] visited,int i,int j,int cur,String word) {
        if (board[i][j] != word.charAt(cur)) return false;
        if (cur == word.length() - 1) return true;
        visited[i][j] = true;
        //对于上下左右四个方向，如果：
        //1、不在边界上；2、未访问过；3、和当前字符相等；
        //则进行下一层访问
        boolean up = false,down = false,left = false,right = false;
        if (i != 0 && !visited[i - 1][j] && board[i - 1][j] == word.charAt(cur + 1)) {
            up = dfs(board,visited,i - 1,j,cur + 1,word);
        }
        if (i != board.length - 1 && !visited[i + 1][j] && board[i + 1][j] == word.charAt(cur + 1)) {
            down = dfs(board,visited,i + 1,j,cur + 1,word);
        }
        if (j != 0 && !visited[i][j - 1] && board[i][j - 1] == word.charAt(cur + 1)) {
            left = dfs(board,visited,i,j - 1,cur + 1,word);
        }
        if (j != board[0].length - 1 && !visited[i][j + 1] && board[i][j + 1] == word.charAt(cur + 1)) {
            right = dfs(board,visited,i,j + 1,cur + 1,word);
        }
        //回溯退回的过程中，将经过的点重新置为false
        visited[i][j] = false;
        return up || down || left || right;
    }
}