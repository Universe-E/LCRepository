import java.util.ArrayList;

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
                //           -1
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