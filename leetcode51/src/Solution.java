import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    List<List<String>> res = new ArrayList<>();
    //逐行放置皇后，分别声明列，左斜线，右斜线所在集合
    //左右斜线分别满足：i + j为常数，i - j为常数
    HashSet<Integer> col = new HashSet<>();
    HashSet<Integer> lDiag = new HashSet<>();
    HashSet<Integer> rDiag = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        backTrack(n,0,new ArrayList<>());
        return res;
    }

    private void backTrack(int n,int i,List<int[]> idx) {
        if (i == n) {
            List<String> cur = generateChess(n,idx);
            res.add(cur);
            return;
        }
        //对于第i行，找适合当前的列
        for (int j = 0; j < n; j++) {
            if (col.contains(j) || lDiag.contains(i+j) || rDiag.contains(i-j)) continue;
            col.add(j);
            lDiag.add(i+j);
            rDiag.add(i-j);
            idx.add(new int[] {i,j});
            backTrack(n,i+1,idx);
            col.remove(j);
            lDiag.remove(i+j);
            rDiag.remove(i-j);
            idx.remove(idx.size() - 1);
        }
    }

    private List<String> generateChess(int n,List<int[]> idx) {
        List<String> cur = new ArrayList<>();
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(chess[i],'.');
        for (int[] ints : idx) chess[ints[0]][ints[1]] = 'Q';
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) sb.append(chess[i][j]);
            cur.add(sb.toString());
        }
        return cur;
    }
}