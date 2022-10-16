class Solution {
    int res = 0;
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        dfs(img1,img2,n);
        return res;
    }
    private void dfs(int[][] img1, int[][] img2,int n) {
        //向右移动i格
        for (int i = 0; i < n; i++) {
            int[][] cur1 = new int[n][n];
            for (int j = 0; j < n; j++) {
                System.arraycopy(img1[j], 0, cur1[j], i, n - i);
            }
            //向下移动j格
            for (int j = 0; j < n; j++) {
                int[][] cur2 = new int[n][n];
                int overlap = 0;
                for (int k = j; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        cur2[k][l] = cur1[k - j][l];
                        if (cur2[k][l] == 1 && img2[k][l] == 1) overlap++;
                    }
                }
                res = Math.max(res,overlap);
            }
            //向上移动j格
            for (int j = 0; j < n; j++) {
                int[][] cur2 = new int[n][n];
                int overlap = 0;
                for (int k = n - 1 - j; k >= 0; k--) {
                    for (int l = 0; l < n; l++) {
                        cur2[k][l] = cur1[k + j][l];
                        if (cur2[k][l] == 1 && img2[k][l] == 1) overlap++;
                    }
                }
                res = Math.max(res,overlap);
            }
        }
        //向左移动i格
        for (int i = n - 1; i >= 0; i--) {
            int[][] cur1 = new int[n][n];
            for (int j = 0; j < n; j++) {
                System.arraycopy(img1[j], i, cur1[j], 0, n - i);
            }
            //向下移动j格
            for (int j = 0; j < n; j++) {
                int[][] cur2 = new int[n][n];
                int overlap = 0;
                for (int k = j; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        cur2[k][l] = cur1[k - j][l];
                        if (cur2[k][l] == 1 && img2[k][l] == 1) overlap++;
                    }
                }
                res = Math.max(res,overlap);
            }
            //向上移动j格
            for (int j = 0; j < n; j++) {
                int[][] cur2 = new int[n][n];
                int overlap = 0;
                for (int k = n - 1 - j; k >= 0; k--) {
                    for (int l = 0; l < n; l++) {
                        cur2[k][l] = cur1[k + j][l];
                        if (cur2[k][l] == 1 && img2[k][l] == 1) overlap++;
                    }
                }
                res = Math.max(res,overlap);
            }
        }
    }
}