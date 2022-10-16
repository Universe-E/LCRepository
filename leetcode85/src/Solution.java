class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] temp = new int[matrix.length][matrix[0].length];
        //记录每一个点从该点向右连续1的个数，即“长度”
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int count = 0;
                for (int k = j; k < matrix[0].length && matrix[i][k] != '0'; k++) count++;
                temp[i][j] = count;
            }
        }
        int res = 0;
        for (int i = 0; i < temp[0].length; i++) {
            //自左往右遍历每一列，类似柱状图求最大矩形面积
            for (int j = 0; j < temp.length; j++) {
                int up = j,down = j;
                while (up >= 0 && temp[up][i] >= temp[j][i]) up--;
                while (down < temp.length && temp[down][i] >= temp[j][i]) down++;
                res = Math.max(res, (down - up - 1) * temp[j][i]);
            }
        }
        return res;
    }
}
