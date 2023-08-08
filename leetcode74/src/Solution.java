class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0;
        for (int k = 0; k < m; k++) {
            if (k == 0 && matrix[k][0] > target) return false;
            if (matrix[k][0] == target) return true;
            else if (k == m - 1 && matrix[k][0] < target) i = m - 1;
            else if (target < matrix[k][0] && target > matrix[k - 1][0]) i = k - 1;
        }
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == target) return true;
        }
        return false;
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, l = 0,r = m*n-1;
        while (l <= r) {
            int mid = (l+r)/2;
            int cur = matrix[mid/n][mid%n];
            if (cur == target) return true;
            else if (cur > target) r = mid-1;
            else l = mid+1;
        }
        return false;
    }
}

