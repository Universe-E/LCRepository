import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e-> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        boolean[] v = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (v[i]) continue;
            var set = new HashSet<Integer>();
            //bfs寻找子图，节点记录在set中
            var q = new ArrayDeque<Integer>();
            q.addLast(i);
            set.add(i);
            v[i] = true;
            while (!q.isEmpty()) {
                int x = q.pollFirst();
                for (Integer y : g[x]) {
                    if (!v[y]) {
                        q.addLast(y);
                        set.add(y);
                        v[y] = true;
                    }
                }
            }
            boolean ok = true;
            for (Integer x : set) {
                if (g[x].size() != set.size()-1) {
                    ok = false;
                    break;
                }
            }
            if (ok) res++;
        }
        return res;
    }
}

class Solution {
    //并查集
    int[] fa,cnt,size;
    private int find(int x) {
        return x == fa[x] ? x : (fa[x] = find(fa[x]));
    }
    private void union(int x,int y) {
        int fx = find(x),fy = find(y);
        if (fx != fy) {
            fa[fx] = fy;
            cnt[fy] += cnt[fx]+1;//添加边数到根节点
            size[fy] += size[fx];
        }
        else cnt[fx]++;
    }
    public int countCompleteComponents(int n, int[][] edges) {
        fa = new int[n];
        cnt = new int[n];
        size = new int[n];
        Arrays.fill(size,1);
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        for (int[] e : edges) {
            union(e[0],e[1]);
        }
        boolean[] v = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int f = find(i);
            if (!v[f]) {
                v[f] = true;
                if (cnt[f] == size[f]*(size[f]-1)/2) res++;//统计边数
            }
        }
        return res;
    }
}