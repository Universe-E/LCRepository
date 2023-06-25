import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair<E, V> {
    E e;
    V v;
    public Pair(E e, V v) {
        this.e = e;
        this.v = v;
    }
}

class Solution {
    ArrayList<Pair<Integer,Double>>[] g;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        g = new ArrayList[n];
        Arrays.setAll(g, e-> new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0],y = edges[i][1];
            g[x].add(new Pair<>(y,succProb[i]));
            g[y].add(new Pair<>(x,succProb[i]));
        }
        double[] dp = new double[n];//dp[i]表示从start开始，到达i点的最大概率
        PriorityQueue<Pair<Integer,Double>> pq = new PriorityQueue<>((o1,o2) -> (o2.v.compareTo(o1.v)));
        pq.add(new Pair<>(start,1d));//初始值为1.0
        dp[start] = 1d;
        while (!pq.isEmpty()) {
            Pair<Integer,Double> p = pq.poll();
            int x = p.e;
            double v = p.v;
            //考察从start到x的概率是否更大
            if (v < dp[x]) continue;
            for (Pair<Integer, Double> p2 : g[x]) {
                int x2 = p2.e;
                double v2 = p2.v;
                //如果从x到x2有更大的概率，则更新概率
                if (dp[x]*v2 > dp[x2]) {
                    dp[x2] = dp[x]*v2;
                    pq.add(new Pair<>(x2,dp[x2]));
                }
            }
        }
        return dp[end];
    }
}