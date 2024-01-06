import java.util.HashSet;

class Solution {
    int res = 0,m,n;
    public int maximumRows(int[][] matrix, int numSelect) {
        m = matrix.length;
        n = matrix[0].length;
        backTrack(matrix,0,numSelect,new HashSet<>());
        return res;
    }

    private void backTrack(int[][] matrix, int idx, int numSelect, HashSet<Integer> colList) {
        if (colList.size() == numSelect) {
            res = Math.max(res,getRow(matrix,colList));
            return;
        }
        for (int i = idx; i < n; i++) {
            colList.add(i);
            backTrack(matrix,i+1,numSelect,colList);
            colList.remove(i);
        }
    }

    private int getRow(int[][] matrix, HashSet<Integer> colList) {
        int res = 0;
        for (int i = 0; i < m; i++) {
            boolean ok = true;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && !colList.contains(j)) {
                    ok = false;
                    break;
                }
            }
            if (ok) res++;
        }
        return res;
    }
}