class Solution {
    public int countBattleships(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    if ((j > 0 && board[i][j] == board[i][j - 1]) || (i > 0 && board[i][j] == board[i - 1][j])) continue;
                    else res++;
                }
            }
        }
        return res;
    }
}