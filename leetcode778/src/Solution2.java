class UnionFind {
    int[] f;
    public int find(int a) {
        if (f[a] == a) return f[a];
        int fa = find(f[a]);
        f[a] = fa;
        return fa;
    }

    public void union(int a,int b) {
        if (isConnected(a,b)) return;
        int fa = find(a), fb = find(b);
        f[fa] = fb;
    }

    public boolean isConnected(int a,int b) {
        return find(a) == find(b);
    }

    public UnionFind(int len) {
        f = new int[len];
        for (int i = 0; i < len; i++) {
            f[i] = i;
        }
    }
}

public class Solution2 {
    int n;
    private static final int[] d = new int[] {-1,0,1,0,-1};
    int[] f;
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        this.n = n;
        int len = n * n;
        f = new int[len];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[grid[i][j]] = getIndex(i,j);
            }
        }
        //寻找每一时间可以连接的点
        UnionFind uf = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            //找到水位为i时对应的[x,y]
            int x = f[i] / n, y = f[i] % n;
            for (int j = 0; j < 4; j++) {
                int cx = x + d[j],cy = y + d[j+1];
                if (cx < 0 || cx >= n || cy < 0 || cy >= n || grid[cx][cy] > i) continue;
                //让符合条件的点相连
                uf.union(f[i],getIndex(cx,cy));
            }
            if (uf.isConnected(0,len-1)) return i;
        }
        return -1;
    }

    private int getIndex(int i, int j) {
        return n * i + j;
    }
}
