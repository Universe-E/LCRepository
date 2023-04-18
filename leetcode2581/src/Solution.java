import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    ArrayList<Integer>[] g;
    HashSet<Long> s;
    int k,res,cnt0;
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        this.k = k;
        int n = edges.length+1;
        g = new ArrayList[n];
        s = new HashSet<>();
        Arrays.setAll(g,e -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        for (int[] guess : guesses) {
            s.add((long)guess[0]<<32 | guess[1]);//将两个int压缩成一个long，存储在哈希表中
        }
        //dfs以0为根的树，确定有多少个猜对的答案，记为cnt0
        dfs(0,-1);
        reRoot(0,-1,cnt0);
        return res;
    }

    private void dfs(int x,int fa) {
        for (Integer y : g[x]) {
            //检查所有与x相邻的边，如果y不是x的父节点，则一定为孩子节点，以y为根继续往下dfs
            if (y != fa) {
                //如果s中包含"x为y的父节点"这种情况，则cnt0自增
                if (s.contains((long)x<<32 | y)) cnt0++;
                dfs(y,x);
            }
        }
    }

    //换根dp，再次dfs
    private void reRoot(int x,int fa,int cnt) {
        if (cnt >= k) res++;
        for (Integer y : g[x]) {
            int cnt2 = cnt;
            if (y != fa) {
                //接下来将y拎起来，此前[x,y]的猜测就错误了，[y,x]的猜测为正确
                //如果节点x和y之间有边，那么从「以x为根的树」变成「以y为根的树」，
                //就只有[x,y]和[y,x]这两个猜测的正确性变了，其余猜测的正确性不变。
                if (s.contains((long) x<<32 | y)) cnt2--;//原来是正确的，现在错了
                if (s.contains((long) y<<32 | x)) cnt2++;//原来猜反了的现在正确了
                //处理完cnt2之后，继续以y为根往下dfs
                reRoot(y,x,cnt2);
            }
        }
    }
}