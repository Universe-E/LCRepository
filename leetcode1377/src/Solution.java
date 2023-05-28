import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    ArrayList<Integer>[] g;
    double res = 1.0;
    boolean flag = false;
    boolean[] v;
    public double frogPosition(int n, int[][] edges, int t, int target) {
        g = new ArrayList[n+1];
        Arrays.setAll(g,e->new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        v = new boolean[n+1];
        long all = 1;
        dfs(1,t,0,target,all);
        return flag ? res : 0.0;
    }

    private void dfs(int i,int t,int times,int target,long all) {
        if (times == t) {
            if (i == target) {
                res /= all;
                flag = true;
            }
            return;
        }
        v[i] = true;
        //没有子节点，原地跳
        if ((i == 1 && g[i].size() == 0) || (i != 1 && g[i].size() == 1)) dfs(i,t,times+1,target,all);
        //有子节点，随机跳
        else {
            for (Integer y : g[i]) {
                //如果i是1，则下一步有g[i].size()个节点，如果i不是1，则下一步有g[i]有g[i].size()-1个节点
                if (!v[y]) dfs(y,t,times+1,target,all*(g[i].size()-(i==1 ? 0 : 1)));
            }
        }
    }
}