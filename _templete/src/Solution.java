import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    private static final int M = (int) 1e9+7;
    private static final int inf = 0x3f3f3f3f;
    //矩阵
    int n,m;
    private static final int[] d = new int[] {1,0,-1,0,1};
    private boolean inArea(int i,int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
    private static final int[][] d2 = new int[][] {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};

    //floodfill计算总面积
    private int fill(int[][] grid,int i, int j) {
        var q = new ArrayDeque<int[]>();
        q.addLast(new int[]{i,j});
        int cnt = 1;
        grid[i][j] = -1;
        while (!q.isEmpty()) {
            var c = q.pollFirst();
            for (int k = 0; k < 8; k++) {
                int cx = c[0]+d2[k][0],cy = c[1]+d2[k][1];
                if (inArea(cx,cy) && grid[cx][cy] == 0) {
                    q.addLast(new int[]{cx,cy});
                    grid[cx][cy] = -1;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    class Pair<E,V> {
        E e;
        V v;
        public Pair(E e,V v) {
            this.e = e;
            this.v = v;
        }
    }

    //无向无权图
    private void addUUG(int n,int[][] edges) {
        ArrayList<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e-> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
    }



    //数位出现次数操作
    int[] cnt = new int[32];
    private void manage(int v,boolean isAdd) {
        for (int i = 0; i < 32; i++) {
            if ((v & (1<<i)) != 0) {
                if (isAdd) cnt[i]++;
                else cnt[i]--;
            }
        }
    }

    //找小于等于time的最大索引
    private int bs_floor(int[][] logs,int time) {
        int l = 0,r = n-1;
        if (logs[l][1] > time) return -1;
        while (l < r) {
            int m = (l+r+1)/2;
            if (logs[m][1] > time) r = m-1;
            else l = m;
        }
        return l;
    }

    //找大于等于time的最小索引
    private int bs_ceiling(int[][] logs,int time) {
        int l = 0,r = n-1;
        if (logs[r][1] < time) return -1;
        while (l < r) {
            int m = (l+r)/2;
            if (logs[m][1] < time) l = m+1;
            else r = m;
        }
        return l;
    }

    //并查集
    int[] fa;
    private int find(int x) {
        return x == fa[x] ? x : (fa[x] = find(fa[x]));
    }
    private void union(int x,int y) {
        int fx = find(x),fy = find(y);
        if (fx != fy) fa[fx] = fy;
    }

    //组合数
    int[][] c;
    private void combination() {
        for (int i = 1; i <= n; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                c[i][j] = (c[i-1][j] + c[i-1][j-1])%M;
            }
        }
    }

    //质数
    boolean[] primes;
    private void sievePrime() {
        Arrays.fill(primes,true);
        for (int i = 2; i <= n; i++) {
            for (int j = 2*i; j <= n; j+=i) {
                primes[j] = false;
            }
        }
    }

    private int gcd(int a,int b) {
        return a%b == 0 ? b : gcd(b,a%b);
    }

    //快速幂
    private int fp(int base,int p) {
        if (p == 1) return base;
        int temp = fp(base,p/2);
        if (p%2 == 0) return (int) ((long)temp*temp%M);
        else return (int) ((long)temp*temp%M*base%M);
    }

}
