import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int flipChess(String[] chessboard) {
        int m = chessboard.length, n = chessboard[0].length();
        char[][] cb = new char[m][n];
        for (int i = 0; i < m; i++) {
            cb[i] = chessboard[i].toCharArray();
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cb[i][j] == '.') res = Math.max(res,dfs(cb,i,j));
            }
        }
        return res;
    }

    private int dfs(char[][] cb, int a, int b) {
        int m = cb.length, n = cb[0].length;
        char[][] temp = new char[m][n];
        for (int k = 0; k < cb.length; k++) {
            temp[k] = Arrays.copyOf(cb[k],n);
        }
        //拷贝一份在[a,b]处下了黑旗的棋盘
        temp[a][b] = 'X';
        //不断遍历整个棋盘的黑棋，找到需要翻转的白棋数量，直到没有新的需要翻转的白棋为止
        int res = 0,curRound;
        do {
            curRound = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (temp[i][j] == 'X') curRound += getNum(temp,i,j);
                }
            }
            res += curRound;
        }while (curRound != 0);
        return res;
    }

    //找到以当前黑棋为中心，需要翻转的白棋所在坐标，对于每个黑棋分8种情况
    private int getNum(char[][] temp, int i, int j) {
        int m = temp.length, n = temp[0].length;
        List<int[]> a = new ArrayList<>(),cur = new ArrayList<>();
        //从左往右
        for (int k = j + 1; k < n; k++) {
            if (temp[i][k] == '.') break;
            if (temp[i][k] == 'O') cur.add(new int[] {i,k});
            if (temp[i][k] == 'X') {
                a.addAll(cur);
                break;
            }
        }
        cur.clear();
        //从右往左
        for (int k = j - 1; k >= 0; k--) {
            if (temp[i][k] == '.') break;
            if (temp[i][k] == 'O') cur.add(new int[] {i,k});
            if (temp[i][k] == 'X') {
                a.addAll(cur);
                break;
            }
        }
        cur.clear();
        //从上到下
        for (int k = i + 1; k < m; k++) {
            if (temp[k][j] == '.') break;
            if (temp[k][j] == 'O') cur.add(new int[] {k,j});
            if (temp[k][j] == 'X') {
                a.addAll(cur);
                break;
            }
        }
        cur.clear();
        //从下到上
        for (int k = i - 1; k >= 0; k--) {
            if (temp[k][j] == '.') break;
            if (temp[k][j] == 'O') cur.add(new int[] {k,j});
            if (temp[k][j] == 'X') {
                a.addAll(cur);
                break;
            }
        }
        cur.clear();
        //从左上到右下
        for (int k = 1; k < Math.min(m - i,n - j); k++) {
            if (temp[i + k][j + k] == '.') break;
            if (temp[i + k][j + k] == 'O') cur.add(new int[] {i + k,j + k});
            if (temp[i + k][j + k] == 'X') {
                a.addAll(cur);
                break;
            }
        }
        cur.clear();
        //从左下到右上
        for (int k = 1; k < Math.min(i + 1,n - j); k++) {
            if (temp[i - k][j + k] == '.') break;
            if (temp[i - k][j + k] == 'O') cur.add(new int[] {i - k,j + k});
            if (temp[i - k][j + k] == 'X') {
                a.addAll(cur);
                break;
            }
        }
        cur.clear();
        //从右下到左上
        for (int k = 1; k < Math.min(i + 1,j + 1); k++) {
            if (temp[i - k][j - k] == '.') break;
            if (temp[i - k][j - k] == 'O') cur.add(new int[] {i - k,j - k});
            if (temp[i - k][j - k] == 'X') {
                a.addAll(cur);
                break;
            }
        }
        cur.clear();
        //从右上到左下
        for (int k = 1; k < Math.min(m - i,j + 1); k++) {
            if (temp[i + k][j - k] == '.') break;
            if (temp[i + k][j - k] == 'O') cur.add(new int[] {i + k,j - k});
            if (temp[i + k][j - k] == 'X') {
                a.addAll(cur);
                break;
            }
        }
        //将8个方向所有的棋子翻转
        for (int[] ints : a) {
            int c = ints[0], d = ints[1];
            temp[c][d] = 'X';
        }
        return a.size();
    }
}