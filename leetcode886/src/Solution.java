import java.util.ArrayList;

class Solution {
    ArrayList<Integer>[] g;
    int[] color;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        color = new int[n+1];
        g = new ArrayList[n+1];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        //建图通式
        for (int[] d : dislikes) {
            int a = d[0], b = d[1];
            g[a].add(b);
            g[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            //如果没有染色，接下来开始染色，0为未染色，1为染红色，2为染蓝色
            if (color[i] == 0) {
                if (!dfs(i,1)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, int c) {
        color[i] = c;
        for (Integer p : g[i]) {
            if (color[p] == 0) {
                //如果没有染色，就从这个点开始染色
                if (!dfs(p,3-c)) return false;
            }
            //如果已经染色了，不能和当前点颜色相同
            else if (color[p] == c) return false;
        }
        return true;
    }
}