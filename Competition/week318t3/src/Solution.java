import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int l = candidates-1,r = n-candidates;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1,o2) -> (costs[o1]==costs[o2] ? o1-o2 : costs[o1]-costs[o2]));
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1,o2) -> (costs[o1]==costs[o2] ? o1-o2 : costs[o1]-costs[o2]));
        int[] cnt = new int[n];
        for (int i = 0; i <=l; i++) {
            pq1.add(i);
            cnt[i]++;
        }
        for (int i = Math.max(l+1,r); i < n; i++) {
            pq2.add(i);
            cnt[i]++;
        }
        long sum = 0;
        int i = 0;
        while (i < k) {
            int p1 = -1, p2 = -1;
            if (!pq1.isEmpty()) p1 = pq1.peek();
            if (!pq2.isEmpty()) p2 = pq2.peek();
            int c1 = p1==-1 ? 100005 : costs[p1];
            int c2 = p2==-1 ? 100005 : costs[p2];
            if (!pq1.isEmpty() && c1 <= c2) {
                sum += c1;
                pq1.poll();
                if (l != n-1 && cnt[l+1] == 0) {
                    pq1.add(l+1);
                    cnt[l+1]++;
                    l++;
                }
            }
            else if (!pq2.isEmpty() && c1 > c2) {
                sum += c2;
                pq2.poll();
                if (cnt[r-1] == 0) {
                    pq2.add(r-1);
                    cnt[r-1]++;
                    r--;
                }
            }
            i++;
        }
        return sum;
    }
}