import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        //反图
        ArrayList<Integer>[] rg = new ArrayList[n];
        Arrays.setAll(rg,e->new ArrayList<>());
        //入度
        int[] indeg = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                rg[graph[i][j]].add(i);//构建反图，即翻转出入边
            }
            indeg[i] = graph[i].length;//反图的入度就是原图的出度
        }
        var q = new ArrayDeque<Integer>();
        //首先将入度为0的点存入队列
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) q.addLast(i);
        }
        while (!q.isEmpty()) {
            int x = q.pollFirst();
            //寻找原图中和当前x相连的点
            for (Integer y : rg[x]) {
                indeg[y]--;//将以x为”起点“的边删除，同时相应y的入度减少
                if (indeg[y] == 0) q.addLast(y);//如果入度减为0，则添加到队列中，此时说明原图中的y已经没有出边
            }
        }
        //全部处理完毕后，最终原图中没有出边的点即为“安全点”
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) res.add(i);
        }
        return res;
    }
}