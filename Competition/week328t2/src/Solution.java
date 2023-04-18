import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        int[][] row = new int[n][n+1];
        for (int[] query : queries) {
            int a1 = query[0],a2 = query[2],b1 = query[1],b2 = query[3];
            for (int i = a1; i <= a2; i++) {
                row[i][b1]++;
                row[i][b2+1]--;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) res[i][j] = row[i][j];
                else res[i][j] = res[i][j-1] + row[i][j];
            }
        }
        return res;
    }

    public int[][] rangeAddQueries2(int n, int[][] queries) {
        int[][] res = new int[n][n];
        for (int[] query : queries) {
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    res[i][j]++;
                }
            }
        }
        return res;
    }

    @Test
    public void tle() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("500\r\n[");
        for (int i = 0; i < 10000; i++) {
            sb.append("[0,0,499,499]");
            if (i != 9999) sb.append(',');
        }
        sb.append("]");
        FileOutputStream fos = new FileOutputStream("D:\\TLEcase.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write(sb.toString());
        osw.close();
        fos.close();
    }

    public static void main(String[] args) throws IOException {

        new Solution().tle();
        int n = 500;
        int[][] queries = new int[10000][4];
        for (int i = 0; i < 10000; i++) {
            queries[i][2] = 499;
            queries[i][3] = 499;
        }
        long startTime = System.currentTimeMillis();
        new Solution().rangeAddQueries(n,queries);
        long endTime = System.currentTimeMillis();
        System.out.println("costTime: " + (endTime - startTime) + " ms");

        long startTime2 = System.currentTimeMillis();
        new Solution().rangeAddQueries2(n,queries);
        long endTime2 = System.currentTimeMillis();
        System.out.println("costTime: " + (endTime2 - startTime2) + " ms");
    }

}