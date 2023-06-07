import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    ArrayList<int[]>[] g;
    int n;
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        this.n = n;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0],y = edges[i][1];
            g[x].add(new int[] {y,i});
            g[y].add(new int[] {x,i});
        }
        var dis = new int[n][2];
        //初始时，除起点外的所有边设为最大值
        for (int i = 0; i < n; i++) {
            if (i != source) Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        dijkstra(edges,destination,dis,0,0);
        int delta = target - dis[destination][0];
        //-1 全改为 1 时，最短路比 target 还大
        if (delta < 0) return new int[][] {};
        dijkstra(edges,destination,dis,delta,1);
        //最短路无法再变大，无法达到 target
        if (dis[destination][1] < target) return new int[][] {};
        for (int[] e : edges) {
            if (e[2] == -1) e[2] = 1;
        }
        return edges;
    }

    //// 这里 k 表示第一次/第二次
    private void dijkstra(int[][] edges,int destination,int[][] dis,int delta,int k) {
        var v = new boolean[n];
        while (true) {
            //找到当前最短路，更新邻居的最短路
            //根据数学归纳法，dis[x][k] 一定是最短路长度
            int x = -1;
            for (int i = 0; i < n; i++) {
                if (!v[i] && (x < 0 || dis[i][k] < dis[x][k])) x = i;
            }
            if (x == destination) return;//起点到终点的最短路已经确定
            v[x] = true;//在后续的循环中无需反复更新x到其余点的长度
            for (int[] e : g[x]) {
                int y = e[0],eid = e[1];
                int wt = edges[eid][2];
                if (wt == -1) wt = 1;//-1改成1
                //如果k=1，进行第2次dijkstra
                //如果第2遍 Dijkstra 跑完后，从起点到终点的最短路仍然小于target，那么就说明无法修改，返回空数组。
                //否则，答案就是我们在第二遍 Dijkstra 中作出的修改。注意第二遍 Dijkstra 跑完后可能还有些边是−1
                //（因为在w=1的时候没有修改，或者有些边不影响最短路），把这些边都改成1 就行。
                if (k == 1 && edges[eid][2] == -1) {
                    //改成w
                    int w = delta + dis[y][0] - dis[x][1];
                    if (w > wt) edges[eid][2] = wt = w;//直接在edges上修改
                }
                //更新最短路
                dis[y][k] = Math.min(dis[y][k],dis[x][k]+wt);
            }
        }
    }
}