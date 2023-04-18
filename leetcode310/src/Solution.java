import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int n;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        this.n = n;
        //建图
        ArrayList<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            int x = edges[i][0], y = edges[i][1];
            g[x].add(y);
            g[y].add(x);
        }
        int[] parent = new int[n];
        Arrays.fill(parent,-1);
        //先找到距离0最远的点x，再找距离x最远的点y
        int x = findLongest(0,parent,g);
        int y = findLongest(x,parent,g);
        //长度为x到y的路径长度/2取上界
        //从y开始，找到该路径，将坐标存储在path中
        ArrayList<Integer> path = new ArrayList<>();
        //因为要从y找到x，因此x的parent置为-1
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }
        int m = path.size();
        List<Integer> res = new ArrayList<>();
        if (m % 2 == 0) res.add(path.get(m / 2 - 1));
        res.add(path.get(m / 2));
        return res;
    }

    private int findLongest(int i, int[] parent,ArrayList<Integer>[] g) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        deque.add(i);
        visited[i] = true;
        //声明路径最长的点的终点
        int des = -1;
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            des = cur;
            for (Integer p : g[cur]) {
                if (visited[p]) continue;
                parent[p] = cur;
                deque.add(p);
                visited[p] = true;
            }
        }
        return des;
    }
}