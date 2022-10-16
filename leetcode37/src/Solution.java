class Solution {
    public void solveSudoku(char[][] board) {
        backTrack(board);
    }
    //将棋盘编号为0-80，记为pos
    private boolean backTrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char c = '1'; c <= '9'; c++) {
                    if (isValid(board,i,j,c)) {
                        board[i][j] = c;
                        //这里是逐层递归返回
                        if (backTrack(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;//如果9个数字都不符合，返回false
            }
        }
        return true;//填完了最后一个数字，返回true
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        //逐行，逐列，逐九宫格找结果
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c) return false;
        }
        for (int k = 0; k < 9; k++) {
            if (board[k][j] == c) return false;
        }
        for (int k = (i / 3) * 3; k < ((i / 3) * 3) + 3; k++) {
            for (int l = (j / 3) * 3; l < ((j / 3) * 3) + 3; l++) {
                if (board[k][l] == c) return false;
            }
        }
        return true;
    }
}