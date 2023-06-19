import java.util.Arrays;

public class Solution {
    int n,m;
    private static final int M = (int) 1e9+7;
    private static final int inf = 0x3f3f3f3f;
    //矩阵
    private static final int[] d = new int[] {1,0,-1,0,1};
    private boolean inArea(int i,int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
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
        return b == 0 ? a : gcd(b,a%b);
    }

    //快速幂
    private int fp(int base,int p) {
        if (p == 1) return base;
        int temp = fp(base,p/2);
        if (p%2 == 0) return (int) ((long)temp*temp%M);
        else return (int) ((long)temp*temp%M*base%M);
    }

}
