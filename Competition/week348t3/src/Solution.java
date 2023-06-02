import java.util.HashSet;

class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        long res = 0;
        int len = queries.length;
        HashSet<Integer> col = new HashSet<>(),row = new HashSet<>();
        for (int i = len-1; i >= 0; i--) {
            int type = queries[i][0],index = queries[i][1];
            if (type == 0 && !row.contains(index)) {
                res += (long) (n-col.size())*queries[i][2];
                row.add(index);
            }
            else if (type == 1 && !col.contains(index)){
                res += (long) (n-row.size())*queries[i][2];
                col.add(index);
            }
        }
        return res;
    }
}