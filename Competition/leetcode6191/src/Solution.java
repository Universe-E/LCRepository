import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

class Solution {
    int[] fa;
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        //构建无向图
        ArrayList<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph,e -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            graph[x].add(y);
            graph[y].add(x);
        }

        fa = new int[n];
        Integer[] id = new Integer[n];
        //初始时，fa中没有任何元素相连，因此fa[i]各不相同
        for (int i = 0; i < n; i++) {
            fa[i] = i;
            id[i] = i;
        }
        //对于id数组中的索引，按照vals中的值大小从低到高排序
        Arrays.sort(id, Comparator.comparingInt(o -> vals[o]));
        //size[x]表示节点值等于vals[x]的个数，如果按照节点由小到大排序，则size[x]表示最大值的个数
        int[] size = new int[n];
        Arrays.fill(size,1);
        //res至少有节点数这么多
        int res = n;
        for (Integer x : id) {
            //从高到低，分别找每个点的根节点
            int vx = vals[x],idx = find(x);
            //然后，找每个点连通的索引
            for (Integer y : graph[x]) {
                //首先，找到当前点的根节点所在索引
                y = find(y);
                if (y == idx || vals[y] > vx) continue;//索引不能是根节点自身，索引对应的值应不能大于当前节点的值
                if (vals[y] == vx) {//当前构成了好路径
                    //因为vals[y] == vals[x]，所以此时的结果即是每个和x根节点所在索引（idx）值相同的节点到y的路径条数，
                    //和索引y值相同的节点个数为size[y]，故此时的结果是size[idx] * size[y]
                    res += size[idx] * size[y];
                    size[idx] += size[y];
                }
                //如果当前节点值小于vx，则将其与x根节点所在索引（idx）连接起来
                fa[y] = idx;
            }
        }
        return res;
    }

    //find相当于是找并查集中的根节点，根节点的值等于自身
    private int find(int x) {
        while (fa[x] != x) x = fa[x];
        return x;
    }
}