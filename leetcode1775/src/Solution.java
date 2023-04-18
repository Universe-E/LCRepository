import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > 6*n2 || n2 > 6*n1) return -1;
        int res = 0, sum1 = 0, sum2 = 0;
        for (int num : nums1) sum1 += num;
        for (int num : nums2) sum2 += num;
        if (sum1 == sum2) return res;
        PriorityQueue<Integer> pq1,pq2;
        System.out.println(sum1 + "," + sum2);
        if (sum1 > sum2) {
            pq1 = new PriorityQueue<>((o1,o2) -> (o2-o1));
            pq2 = new PriorityQueue<>();
            for (int num : nums1) pq1.add(num);
            for (int num : nums2) pq2.add(num);
            while (sum1 != sum2) {
                int p1 = pq1.peek(), p2 = pq2.peek();
                int diff1 = Math.min(p1-1,sum1-sum2), diff2 = Math.min(6-p2,sum1-sum2);
                if (diff1 >= diff2) {
                    pq1.poll();
                    pq1.add(p1-diff1);
                    sum1 -= diff1;
                }
                else {
                    pq2.poll();
                    pq2.add(p2+diff2);
                    sum2 += diff2;
                }
                res++;
            }
        }
        else {
            pq1 = new PriorityQueue<>();
            pq2 = new PriorityQueue<>((o1,o2) -> (o2-o1));
            for (int num : nums1) pq1.add(num);
            for (int num : nums2) pq2.add(num);
            while (sum1 != sum2) {
                int p1 = pq1.peek(), p2 = pq2.peek();
                int diff1 = Math.min(6-p1,sum2-sum1), diff2 = Math.min(p2-1,sum2-sum1);
                System.out.println(p1 + "," + p2);
                if (diff1 >= diff2) {
                    pq1.poll();
                    pq1.add(p1+diff1);
                    sum1 += diff1;
                }
                else {
                    pq2.poll();
                    pq2.add(p2-diff2);
                    sum2 -= diff2;
                }
                res++;
            }
        }
        return res;
    }
}