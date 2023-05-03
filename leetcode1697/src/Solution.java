import java.util.Arrays;
import java.util.Comparator;

class Solution {
    int[] fa;
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        fa = new int[n+1];
        int m = queries.length, len = edgeList.length;
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        //加上序号
        for (int i = 0; i < m; i++) {
            queries[i] = new int[] {i,queries[i][0],queries[i][1],queries[i][2]};
        }
        //根据limit排序
        Arrays.sort(queries, Comparator.comparingInt(o -> o[3]));
        //根据距离dis排序
        Arrays.sort(edgeList,Comparator.comparingInt(o -> o[2]));
        boolean[] res = new boolean[m];
        for (int i = 0,j = 0; i < m; i++) {
            //保证每一条边都严格小于当前i的limit，如果小于，则合并到一个并查集中
            while (j < len && edgeList[j][2] < queries[i][3]) {
                union(edgeList[j][0],edgeList[j][1]);
                j++;
            }
            res[queries[i][0]] = isConnected(queries[i][1],queries[i][2]);
        }
        return res;
    }

    private int find(int x) {
        if (x != fa[x]) fa[x] = find(fa[x]);
        return fa[x];
    }

    private void union(int x,int y) {
        int fx = find(x),fy = find(y);
        fa[fy] = fx;
    }

    private boolean isConnected(int x,int y) {
        return find(x) == find(y);
    }
}