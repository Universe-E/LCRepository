import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length,l = 0,r = n-1;
        long res = 0;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(),
                pq2 = new PriorityQueue<>();
        while (l < candidates) pq1.add(costs[l++]);
        while (r >= l && r >= n-candidates) pq2.add(costs[r--]);
        while (k > 0) {
            int p1 = pq1.isEmpty() ? -1 : pq1.peek();
            int p2 = pq2.isEmpty() ? -1 : pq2.peek();
            //没有可取的元素
            if (p1 == -1 && p2 == -1) return res;
            //都可取，比较两个元素大小
            if (p1 != -1 && p2 != -1) {
                if (p1 > p2) {
                    res += p2;
                    pq2.poll();
                    if (r >= l) pq2.add(costs[r--]);
                }
                else {
                    res += p1;
                    pq1.poll();
                    if (l <= r) pq1.add(costs[l++]);
                }
            }
            //只有1个可取
            else {
                if (p1 == -1) {
                    res += p2;
                    pq2.poll();
                    if (r >= l) pq2.add(costs[r--]);
                }
                else {
                    res += p1;
                    pq1.poll();
                    if (l <= r) pq1.add(costs[l++]);
                }
            }
            k--;
        }
        return res;
    }
}