import java.util.ArrayList;

public class Solution2 {
    ArrayList<Integer>[] g;
    int[] fa;//fa[i]表示i的父节点
    public boolean possibleBipartition(int n, int[][] dislikes) {
        fa = new int[n+1];
        g = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            fa[i] = i;
            g[i] = new ArrayList<>();
        }
        for (int[] d : dislikes) {
            g[d[0]].add(d[1]);
            g[d[1]].add(d[0]);
        }
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> cur = g[i];
            for (Integer j : cur) {
                //相邻点根节点不能相同
                if (find(i) == find(j)) return false;
                //i与其第一个相邻点的根节点必不同，因此可以将j划到这一组
                int neighbor = cur.get(0);
                connect(j,neighbor);
            }
        }
        return true;
    }

    private int find(int i) {
        //并查集性质，根节点的父节点指向自己
        //否则让当前节点的父亲等于父亲的根节点，实现路径压缩
        if (fa[i] != i) fa[i] = find(fa[i]);
        return fa[i];
    }
    private void connect(int i,int j) {
        if (find(i) == find(j)) return;
        //i的根节点是fi,j的根节点是fj
        int fi = find(i),fj = find(j);
        //连接过程，让fi的父节点等于fj即可
        fa[fi] = fa[fj];
    }
}
