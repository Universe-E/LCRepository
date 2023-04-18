import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//先统计一遍cnt[]，然后用price[i]*cnt[i]更新price数组
//问题就变成计算减半后的price[i]之和的最小值。
//随便选一个节点出发DFS分类讨论
class Solution {
    ArrayList<Integer>[] g;
    int n;
    int[] price,cnt;
    int end;
    public static final int inf = 0x3f3f3f3f;
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        this.n = n;
        g = new ArrayList[n];
        this.price = price;
        cnt = new int[n];
        Arrays.setAll(g,e -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        for (int[] t : trips) {
            end = t[1];
            dfs(t[0],-1);
        }
        int[] res = dp(0,-1);
        return Math.min(res[0],res[1]);

    }

    private boolean dfs(int x,int fa){
        if (x == end) {//到达终点（注意树只有唯一的一条简单路径）
            cnt[x]++;
            return true;
        }
        for (Integer y : g[x]) {
            if (y != fa && dfs(y,x)) {//从y开始继续dfs
                cnt[x]++;//由于dfs(y,x)为true，说明从x能到达end，是一条可行的路径
                return true;
            }
        }
        return false;
    }

    //树形dp找最小折半
    private int[] dp(int x,int fa) {
        int no = price[x] * cnt[x];//不选
        int yes = no/2;//选
        for (Integer y : g[x]) {
            if (y != fa) {
                int[] ry = dp(y,x);
                yes += ry[1];//如果选了x，则y不能被选，因此yes += ry[1]
                no += Math.min(ry[0],ry[1]);//如果不选x，则y既可以选也可以不选，此时取最小值
            }
        }
        return new int[]{yes,no};
    }
}