class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        return checkDirection(board, rMove, cMove, color, 1, 0)  // 垂直向下
                || checkDirection(board, rMove, cMove, color, -1, 0)  // 垂直向上
                || checkDirection(board, rMove, cMove, color, 0, 1)   // 水平向右
                || checkDirection(board, rMove, cMove, color, 0, -1)  // 水平向左
                || checkDirection(board, rMove, cMove, color, 1, 1)   // 对角线右下
                || checkDirection(board, rMove, cMove, color, 1, -1)  // 对角线左下
                || checkDirection(board, rMove, cMove, color, -1, 1)  // 对角线右上
                || checkDirection(board, rMove, cMove, color, -1, -1);// 对角线左上
    }

    private boolean checkDirection(char[][] board, int rMove, int cMove, char color, int dr, int dc) {
        int r = rMove + dr, c = cMove + dc;
        boolean foundOppositeColor = false;

        while (r >= 0 && r < 8 && c >= 0 && c < 8) {
            if (board[r][c] == '.') return false;
            if (board[r][c] != color) {
                foundOppositeColor = true;
            } else {
                return foundOppositeColor;
            }
            r += dr;
            c += dc;
        }
        return false;
    }
}