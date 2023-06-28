import java.util.ArrayDeque;

class Solution {
    int n,m;
    private static final int[] d = new int[] {1,0,-1,0,1};
    private boolean inArea(int i,int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
    public int shortestPathAllKeys(String[] grid) {
        n = grid.length;
        m = grid[0].length();
        int[] start = new int[4];
        int keys = 0;
        char[][] cs = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cs[i][j] = grid[i].charAt(j);
                if (cs[i][j] == '@') {
                    start[0] = i;
                    start[1] = j;
                }
                //统计存在几个钥匙
                if (Character.isLowerCase(cs[i][j])) keys++;
            }
        }
        boolean[][][] v = new boolean[n][m][(1<<keys)];
        var q = new ArrayDeque<int[]>();
        q.addLast(start);
        v[0][0][0] = true;
        while (!q.isEmpty()) {
            var a = q.pollFirst();
            int i = a[0],j = a[1],k = a[2],len = a[3];
            //获取了所有钥匙
            if (k == (1<<keys)-1) return len;
            for (int d0 = 0; d0 < 4; d0++) {
                int i2 = i+d[d0],j2 = j+d[d0+1],k2 = k;
                if (inArea(i2,j2)) {
                    char c = cs[i2][j2];
                    //墙
                    if (c == '#') continue;
                    //找到钥匙，可以不修改cs[i2][j2]的状态，直接按位或即可
                    //注意这里不能直接修改k,而是要用k2接收k，否则遍历其他位置时，造成“隔空取钥匙”导致步数缩短
                    if (Character.isLowerCase(c)) k2 |= 1<<(c-'a');
                    //遇到锁，没有钥匙
                    if (Character.isUpperCase(c) && (k2 & (1<<(c-'A'))) == 0) continue;
                    //该状态之前访问过
                    if (v[i2][j2][k2]) continue;
                    v[i2][j2][k2] = true;
                    q.addLast(new int[] {i2,j2,k2,len+1});
                }
            }
        }
        return -1;
    }
}