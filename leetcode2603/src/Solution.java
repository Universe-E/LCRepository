import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        //如果叶子节点没有金币，没有必要移动到叶子节点
        //可以先把这些没有金币的叶子节点去掉。如果去掉后又产生了新的没有金币的叶子节点，就继续去掉。
        //由于可以「收集距离当前节点距离为2以内的所有金币」，
        //我们没有必要移动到叶子节点再收集，而是移动到叶子节点的父节点的父节点，就能收集到叶子节点上的金币
        //那么，去掉所有叶子，然后再去掉新产生的叶子，剩余节点就是必须要访问的节点
        int n = coins.length;
        ArrayList<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g,e->new ArrayList<>());
        int[] deg = new int[n];//入度为1的是叶子节点
        for (int[] e : edges) {
            int x = e[0],y = e[1];
            g[x].add(y);
            g[y].add(x);
            deg[x]++;
            deg[y]++;
        }
        int leftEdge = n-1;//统计剩余边数
        //拓补排序
        var q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            //加上没有金币的叶子节点
            if (deg[i] == 1 && coins[i] == 0) q.addLast(i);
        }
        //删除所有没有金币的叶子节点及其新产生的没有金币的叶子节点
        while (!q.isEmpty()) {
            int x = q.pollFirst();
            leftEdge--;
            for (Integer y : g[x]) {
                deg[y]--;
                if (deg[y] == 1 && coins[y] == 0) q.addLast(y);
            }
        }
        //全部删完，只剩下叶子节点有金币的树，此时再次拓补排序
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1 && coins[i] == 1) q.addLast(i);
        }
        //这些叶子节点及其父节点都可以删去
        for (Integer x : q) {
            leftEdge--;//x全都要被删除，所以每次leftDeg减1
            for (Integer y : g[x]) {
                deg[y]--;
                //如果删完x之后的y也要被删除，那么继续leftDeg减1
                if (deg[y] == 1) leftEdge--;
            }
        }
        //如果最后把树删空了，leftDeg会为-1，因为最后一条边会删两次
        return leftEdge == -1 ? 0 : 2*leftEdge;
    }
}