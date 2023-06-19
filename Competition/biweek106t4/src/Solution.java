import java.util.*;

class Solution {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> res = new ArrayList<>();
        //状态最多有2^n个
        TreeSet<Integer>[] g = new TreeSet[(1<<n)];//g存储每个10进制对应数的坐标
        Arrays.setAll(g, e-> new TreeSet<>());
        for (int i = 0; i < m; i++) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                num <<= 1;
                num += grid[i][j];
            }
            if (num == 0) {
                res.add(i);
                return res;
            }
            g[num].add(i);
        }
        for (int i = 0; i < (1 << n); i++) {
            for (int j = i+1; j < (1 << n); j++) {
                if ((i | j) == i+j && !g[i].isEmpty() && !g[j].isEmpty()) {
                    res.add(g[i].first());
                    res.add(g[j].first());
                    Collections.sort(res);
                    return res;
                }
            }
        }
        return new ArrayList<>();
    }
}