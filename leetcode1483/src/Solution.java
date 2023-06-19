import java.util.ArrayList;
import java.util.Arrays;

class TreeAncestor {
    //dp[i][j] represents the 2^j th parents of node i
    ArrayList<Integer>[] dp;
    public TreeAncestor(int n, int[] parent) {
        dp = new ArrayList[n];
        //initialize dp, add each first parents to dp[i]
        for (int i = 0; i < n; i++) {
            dp[i] = new ArrayList<>();
            dp[i].add(parent[i]);
        }
        for (int j = 1; ; j++) {
            // 判断 节点0 ，2 ....n-1的第2^j次方个父亲节点是否都为-1
            boolean allNegative = true;
            for (int i = 0; i < n; i++) {
                // 对于 节点i的 第 2^j 个父亲节点
                // 如果 ： i 的 第 2^(j-1) 个父亲节点已经是-1了
                //          那么 也将 i 的 第 2^j个父节点也设置为 -1;
                // 否则 ： 将i的第2^j 个父节点 设置为 i的第2^(j-1)个父亲节点的第2^(j-1)个父亲节点
                //           dp[dp[i].get(j-1)].get(j-1);
                int t = dp[i].get(j-1)==-1 ? -1 : dp[dp[i].get(j-1)].get(j-1);
                dp[i].add(t);
                if (t != -1) allNegative = false;
            }
            // 如果所有节点的 第2^j次方个父亲节点都已经设置为 -1，则跳出循环
            if (allNegative) break;
        }

    }

    public int getKthAncestor(int node, int k) {
        int res = node, pos = 0;
        while (k != 0 && res != -1) {
            if (pos >= dp[res].size()) return -1;
            if ((k & 1) != 0) res = dp[res].get(pos);
            k >>= 1;
            pos++;
        }
        return res;
    }
}

class TreeAncestor {
    //定义ancestors[i][j]表示节点i的第2^j个祖先。此题中，树最多有50000 个节点，
    //因此ancestors 的第二维度的最大值可以设为16
    int[][] ancestors;
    public TreeAncestor(int n, int[] parent) {
        ancestors = new int[n][16];
        //第2^0个祖先就是parent[i]
        for (int i = 0; i < n; i++) {
            Arrays.fill(ancestors[i],-1);
            ancestors[i][0] = parent[i];
        }
        //从1开始转移，类似快速幂的思路
        //i的第2^j个祖先，等价于i的第2^(j-1)个祖先的第2^(j-1)个祖先
        for (int j = 1; j < 16; j++) {
            for (int i = 0; i < n; i++) {
                if (ancestors[i][j-1] != -1) ancestors[i][j] = ancestors[ancestors[i][j-1]][j-1];
            }
        }
    }

    //类似快速幂
    public int getKthAncestor(int node, int k) {
        if (node == -1) return -1;
        if (k == 1) return ancestors[node][0];
        int p = 0;
        while ((1 << p) < k) p++;
        //问题转化为得到node的第2^(p-1)个祖先的第（k-2^(p-1)）个祖先
        return getKthAncestor(ancestors[node][p-1],k-(1<<(p-1)));
    }
}