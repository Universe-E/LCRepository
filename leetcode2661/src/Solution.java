import java.util.HashMap;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length,m = mat[0].length;
        HashMap<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(mat[i][j],new int[]{i,j});
            }
        }
        int[] col = new int[m],row = new int[n];
        for (int i = 0; i < n * m; i++) {
            int[] p = map.get(arr[i]);
            row[p[0]]++;
            col[p[1]]++;
            if (row[p[0]] == m || col[p[1]] == n) return i;
        }
        return n;
    }
}