import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    int n,len,res;
    public int maximumRequests(int n, int[][] requests) {
        this.n = n;
        len = requests.length;
        res = 0;
        //直接穷举所有状态
        for (int i = 0; i < (1 << len); i++) {
            res = Math.max(res,calculate(i,requests));
        }
        return res;
    }

    private int calculate(int con,int[][] requests) {
        int[] req = new int[n];
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if ((con&(1<<i)) != 0) {
                req[requests[i][0]]--;
                req[requests[i][1]]++;
                cnt++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (req[i] != 0) return -1;
        }
        return cnt;
    }
}

class Solution {

    static class Node {
        int from,to,diff;
        public Node(int from,int to,int diff) {
            this.from = from;
            this.to = to;
            this.diff = diff;
        }
    }

    public int maximumRequests(int n, int[][] requests) {
        //s,t分别表示源点、汇点
        int s = n,t = n+1,N = n+2,K = 0;
        //计算每个点的出度
        int[] diff = new int[n];
        for (int[] r : requests) {
            diff[r[0]]++;
            diff[r[1]]--;
        }
        //将源点和汇点连边，默认费用为0
        ArrayList<Node> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //从源点连向该点
            if (diff[i] > 0) {
                for (int j = 0; j < diff[i]; j++) {
                    edges.add(new Node(s,i,0));
                }
            }
            //将该点连向汇点
            else if (diff[i] < 0) {
                for (int j = 0; j < -diff[i]; j++) {
                    edges.add(new Node(i,t,0));
                }
            }
            K += Math.max(0,diff[i]);
        }
        //原图中的点默认费用为1
        for (int[] r : requests) {
            edges.add(new Node(r[0],r[1],1));
        }
        //建图
        //为了使得原图流量平衡,必须去掉与S和T相连的边且保持流量平衡,也就是从网络中去掉一个S到T最大流。
        //由于代价就是去掉的边数,因此原图的边需要费用1
        ArrayList<Integer>[] g = new ArrayList[N];
        Arrays.setAll(g,e->new ArrayList<>());
        for (int i = 0; i < edges.size(); i++) {
            g[edges.get(i).from].add(i);
            g[edges.get(i).to].add(i);
        }
        int res = requests.length;
        //寻找最小费用最大流

    }


}