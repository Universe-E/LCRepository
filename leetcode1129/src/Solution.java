import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    public static final int F = 0x3f3f3f3f;
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        //建图，其中数组第二项存储颜色信息，0表示红色，1表示蓝色
        ArrayList<int[]>[] g = new ArrayList[n];
        //v表示从0到i颜色交替的最短距离
        int[][] v = new int[n][2];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            v[i][0] = v[i][1] = F;
        }
        for (int[] r : redEdges) g[r[0]].add(new int[] {r[1],0});
        for (int[] b : blueEdges) g[b[0]].add(new int[] {b[1],1});
        //bfs，分别从红蓝两种颜色出发寻找颜色交替的路径
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[] {0,0});
        q.addLast(new int[] {0,1});
        //0处的点距离默认为0
        v[0][0] = v[0][1] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            //pos为当前点，color为当前路径颜色，d表示该路径的最短距离
            int pos = cur[0], color = cur[1], d = v[pos][color];
            for (int[] arr : g[pos]) {
                //若颜色交替出现，则要求相加为1，否则颜色相同，跳过
                if (color+arr[1] != 1) continue;
                //考察当前点的距离，如果更短则更新
                if (d+1 < v[arr[0]][arr[1]]) {
                    v[arr[0]][arr[1]] = d+1;
                    q.addLast(new int[] {arr[0],arr[1]});
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.min(v[i][0],v[i][1]);
            if (ans[i] == F) ans[i] = -1;
        }
        return ans;
    }
}