import java.util.ArrayList;
import java.util.List;

class Solution {
    int n,m;
    private boolean inArea(int i,int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
    private static final int[][] d2 = new int[][] {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        n = m = 8;
        int[][] g = new int[n][m];
        for (int[] q : queens) {
            g[q[0]][q[1]] = 1;
        }
        for (int[] d : d2) {
            for (int k = 0; inArea(king[0]+k*d[0],king[1]+k*d[1]); k++) {
                if (g[king[0]+k*d[0]][king[1]+k*d[1]] == 1) {
                    res.add(List.of(king[0]+k*d[0],king[1]+k*d[1]));
                    break;
                }
            }
        }
        return res;
    }
}