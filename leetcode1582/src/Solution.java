class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            int p1 = -1;//记录1的位置
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (p1 == -1) p1 = j;//第一次遇到1记录p1为j
                    else {//否则该行有多个1，直接跳过循环
                        p1 = -1;
                        break;
                    }
                }
            }
            if (p1 != -1) {//如果p1不是-1，则检查纵列是否有多个1
                boolean only = true;
                for (int j = 0; j < m; j++) {
                    if (j == i) continue;
                    if (mat[j][p1] != 0) {
                        only = false;
                        break;
                    }
                }
                if (only) res++;
            }
        }
        return res;
    }
}
