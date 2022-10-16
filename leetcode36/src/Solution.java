import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> temp = new HashSet<>();
        //逐行遍历
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (temp.contains(board[i][j])) return false;
                    else temp.add(board[i][j]);
                }
            }
            //每次遍历完一行temp都重置
            temp.clear();
        }
        
        //逐列遍历
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (temp.contains(board[j][i])) return false;
                    else temp.add(board[j][i]);
                }
            }
            temp.clear();
        }
        //按九宫格遍历
        for (int i = 0; i < 9; i++) {
            if (i < 3) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (board[j][k + 3 * i] != '.') {
                            if (temp.contains(board[j][k + 3 * i])) return false;
                            else temp.add(board[j][k + 3 * i]);
                        }
                    }
                }
                temp.clear();
            }
            else if (i < 6) {
                for (int j = 3; j < 6; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (board[j][k + 3 * (i - 3)] != '.') {
                            if (temp.contains(board[j][k + 3 * (i - 3)])) return false;
                            else temp.add(board[j][k + 3 * (i - 3)]);
                        }
                    }
                }
                temp.clear();
            }
            else {
                for (int j = 6; j < 9; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (board[j][k + 3 * (i - 6)] != '.') {
                            if (temp.contains(board[j][k + 3 * (i - 6)])) return false;
                            else temp.add(board[j][k + 3 * (i - 6)]);
                        }
                    }
                }
                temp.clear();
            }
        }
        return true;
    }
}
