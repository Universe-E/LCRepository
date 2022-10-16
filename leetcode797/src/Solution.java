import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.addLast(0);
        dfs(graph,0,graph.length - 1);
        return res;
    }
    private void dfs(int[][] graph,int start,int n) {
        if (start == n) {
            res.add(new ArrayList<>(stack));
            return;
        }
        //对初始数组的每一个元素所在数组进行回溯
        for (int i = 0; i < graph[start].length; i++) {
            stack.addLast(graph[start][i]);
            dfs(graph,graph[start][i],n);
            stack.removeLast();
        }
    }
}
