import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    int res;
    //逐行放置皇后，分别声明列，左斜线，右斜线所在集合
    //左右斜线分别满足：i + j为常数，i - j为常数
    HashSet<Integer> col = new HashSet<>();
    HashSet<Integer> lDiag = new HashSet<>();
    HashSet<Integer> rDiag = new HashSet<>();
    public int totalNQueens(int n) {
        backTrack(n,0,new ArrayList<>());
        return res;
    }

    private void backTrack(int n,int i,List<int[]> idx) {
        if (i == n) {
            res++;
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
}