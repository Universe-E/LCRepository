import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        HashSet<Integer>[] g = new HashSet[n];
        Arrays.setAll(g,e->new HashSet<>());
        int[] deg = new int[n];
        for (int[] e : edges) {
            int x = e[0]-1,y = e[1]-1;
            g[x].add(y);
            g[y].add(x);
            deg[x]++;
            deg[y]++;
        }

        int res = 0x3f3f3f3f;
        for (int i = 0; i < n - 2; i++) {
            if (deg[i] < 2) continue;
            for (int j = i+1; j < n-1; j++) {
                if (deg[j] < 2 || !g[i].contains(j)) continue;
                for (int k = j+1; k < n; k++) {
                    if (g[i].contains(k) && g[j].contains(k)) res = Math.min(res,deg[i]+deg[j]+deg[k]-6);
                }
            }
        }
        return res == 0x3f3f3f3f ? -1 : res;
    }
}

class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        HashSet<Integer>[] g = new HashSet[n];
        Arrays.setAll(g,e->new HashSet<>());
        int[] deg = new int[n];
        for (int[] e : edges) {
            int x = e[0]-1,y = e[1]-1;
            g[x].add(y);
            g[y].add(x);
            deg[x]++;
            deg[y]++;
        }

        //定向后的图
        //出度小的点指向出度大的点，如果出度相等，则索引小的点指向索引大的点
        //新图任意一个点的出度都不会大于sqrt(2m),其中m为总边数
        HashSet<Integer>[] g2 = new HashSet[n];
        Arrays.setAll(g2,e->new HashSet<>());
        for (int[] e : edges) {
            int x = e[0]-1,y = e[1]-1;
            if (deg[x] < deg[y] || (deg[x] == deg[y] && x < y)) g2[x].add(y);
            else g2[y].add(x);
        }

        int res = 0x3f3f3f3f;
        for (int i = 0; i < n; i++) {
            for (Integer j : g2[i]) {
                for (Integer k : g2[j]) {
                    if (g[i].contains(k)) res = Math.min(res,deg[i]+deg[j]+deg[k]-6);
                }
            }
        }
        return res == 0x3f3f3f3f ? -1 : res;
    }
}