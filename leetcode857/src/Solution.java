import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] qs = new double[n][2];//按照工资：质量排序，比例越低说明价性比越高
        for (int i = 0; i < n; i++) {
            //注意！这里作商时不能全部扩住
            qs[i] = new double[] {(double) wage[i] / quality[i],quality[i]};
        }
        Arrays.sort(qs, Comparator.comparingDouble(a -> a[0]));
        //随后按价性比从低到高遍历，当前工人的价性比一定满足前面所有工人
        //同时声明优先队列从高到低存放工人工作质量：
        //当工人数量等于k时，记录此时的工资res = 当前价性比 * k个工人质量工作质量总和
        //若工人数量大于k，此时需要减去此前遍历过工作质量最大的工人（他一个人拉高了工资）
        double res = Double.MAX_VALUE;
        PriorityQueue<Double> pq = new PriorityQueue<>((o1,o2) -> Double.compare(o2,o1));
        double cur = 0;
        for (int i = 0; i < n; i++) {
            cur += qs[i][1];
            pq.add(qs[i][1]);
            if (pq.size() > k) cur -= pq.poll();
            if (pq.size() == k) res = Math.min(res,qs[i][0] * cur);
        }
        return res;
    }
}
