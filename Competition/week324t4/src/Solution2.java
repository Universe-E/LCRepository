public class Solution2 {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int re = 0;
            int x = queries[i][0], y = queries[i][1];
            while (x != y) {
                if (x > y) x /= 2;
                else y /= 2;
                re++;
            }
            res[i] = re + 1;
        }
        return res;
    }
}
