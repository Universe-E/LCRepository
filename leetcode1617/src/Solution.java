import java.util.Arrays;

public class Solution {
    public static final int INF = 0x3f3f3f3f;
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[][] dist = new int[n][n];//dist存储两点间距离
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i],INF);//初始化为最大距离，其实初始化为任意大于n的数即可
            dist[i][i] = 0;//每个点自身距离为0
        }
        int[] dp = new int[1<<n];//状态压缩，dp[j]表示第j个子树的距离
        //j表示成二进制，从右数第k位为1表示第k个节点在子集中否则不在
        for (int[] edge : edges) {
            //由于索引从1开始，这里要减1
            int a = edge[0]-1, b = edge[1]-1;
            //直接相连的点距离为1
            dist[a][b] = 1;
            dist[b][a] = 1;
            //直接相连的两点可以构成一棵子树，它们的最大距离为1
            dp[(1<<a) + (1<<b)] = 1;
        }
        //floyd算法，计算每两点间最短距离，需要背诵
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //枚举所有已更新的ik,jk边，找两点间最短距离
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        // 把对j的循环放在外面
        // 因为显然如果子树A是子树B的一部分 jA<jB
        // 所以要把数字小的j全部求好了再去求数字大的j
        for (int j = 0; j < dp.length; j++) {
            // 以下我们从子树 j 扩展到子树 j+(1<<i)
            // 即把节点i加入到子树j中
            // 如果本身j就无法构成一棵子树（如果j表示的节点不能相互连通）
            // 那么也就没有必要继续了 所以continue
            if (dp[j] == 0) continue;
            for (int i = 0; i < n; i++) {
                // 如果节点i已经在子树j中 或者 j+(1<<i)已经被计算过了 就没必要算了
                // 为什么它可能会已经被计算过呢？
                // 因为 111=101+10=11+100 添加点的顺序不同 但是能得出同样的一棵子树
                if (((1<<i)&j) != 0 || dp[j+(1<<i)] != 0) continue;
                // 检查 j 子树中是否有和 i 直接相连的点
                // 这其实是相对于子树（而不是某个节点的）的bfs
                for (int k = 0; k < n; k++) {
                    if (((1<<k)&j) != 0 && dist[i][k] == 1) {
                        dp[j + (1<<i)] = dp[j];
                        break;
                    }
                }
                // 如果j 子树中没有和 i 直接相连的点
                // 那么也就无法添加这个节点i了
                if(dp[j+(1<<i)]==0) continue;
                // 把节点i添加进来 就要更新新子树的最大距离 dp[j+(1<<i)]
                // 更新的办法是 对于原子树的每一个节点和新节点求最大距离
                // 因为只产生了这些新距离 做增量计算就好
                for(int kk=0; kk<n; kk++){
                    if(((1<<kk)&j)!=0){
                        dp[j+(1<<i)]=Math.max(dp[j+(1<<i)], dist[i][kk]);
                    }
                }
            }
        }
        // 统计结果 由于下标从1开始
        // ans[0]其实记录的是最大距离为1的子树有多少棵 统计时要-1
        int[] ans=new int[n-1];
        for (int i : dp) {
            if (i != 0) ans[i - 1]++;
        }
        return ans;

    }
}
