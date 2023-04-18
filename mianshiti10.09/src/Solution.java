class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        for (int[] ints : matrix) {
            if (target < ints[0]) return false;
            if (target > ints[n - 1]) continue;
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (ints[mid] == target) return true;
                if (target > ints[mid]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return false;
    }
}

class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        if (n == 0) return false;
        int i = 0,j = n-1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) return true;
            //如果仍然大于target，则i,j的右下方一定不存在答案
            if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }
}