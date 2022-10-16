class Solution {
    public static final int UNCOLORED = 0;
    public static final int RED = 1;
    public static final int GREEN = 2;
    int[] colors;
    private boolean valid = true;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        colors = new int[n];
        //由于无向图可能不相连，因此需要遍历搜索所有的节点
        for (int i = 0; i < n; i++) {
            if (!valid) break;
            //初始从未染色的节点出发，将节点i染成红色
            if (colors[i] == UNCOLORED) dfs(graph,RED,i);
        }
        return valid;
    }

    private void dfs(int[][] graph,int color,int start) {
        colors[start] = color;
        //设置当前要染的颜色，和根节点的颜色不同
        int curColor = color == RED ? GREEN : RED;
        for (int child : graph[start]) {
            //如果孩子节点没有染色，则染上curColor
            if (colors[child] == UNCOLORED) {
                dfs(graph,curColor,child);
            }
            //如果孩子节点没有染上目标颜色，则不满足二分图
            else if (colors[child] != curColor) {
                valid = false;
                break;
            }
        }
    }
}