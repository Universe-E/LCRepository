import java.util.PriorityQueue;
import java.util.TreeSet;

class Solution {
    public int getKthMagicNumber(int k) {
        int[] res = new int[k];
        int p3 = 0, p5 = 0, p7 = 0;
        res[0] = 1;
        for (int i = 1; i < k; i++) {
            res[i] = Math.min(res[p3] * 3,Math.min(res[p5] * 5,res[p7] * 7));
            if (res[i] % 3 == 0) p3++;
            if (res[i] % 5 == 0) p5++;
            if (res[i] % 7 == 0) p7++;
        }
        return res[k - 1];
    }
}

class Solution2 {
    public int getKthMagicNumber(int k) {
        TreeSet<Long> set = new TreeSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        set.add(1L);
        pq.add(1L);
        long res = 0;
        for (int i = 0; i < k; i++) {
            long cur = pq.poll();
            res = cur;
            if (set.add(3 * cur)) pq.add(3 * cur);
            if (set.add(5 * cur)) pq.add(5 * cur);
            if (set.add(7 * cur)) pq.add(7 * cur);
        }
        return (int) res;
    }
}