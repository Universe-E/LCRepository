import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length,m = img[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = getAvg(img,i,j);
            }
        }
        return res;
    }

    private int getAvg(int[][] img, int i, int j) {
        int cnt = 0,sum = 0;
        for (int i1 = i-1; i1 <= i+1; i1++) {
            for (int j1 = j-1; j1 <= j+1; j1++) {
                if (i1 >= 0 && i1 < img.length && j1 >= 0 && j1 <img[0].length) {
                    sum += img[i1][j1];
                    cnt++;
                }
            }
        }
        return sum/cnt;
    }
}