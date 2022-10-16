import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Long> res = new ArrayList<>();
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        int[] ptrs = new int[m];
        int p = 0;
        res.add(1L);
        while (p < n) {
            long cur = getMin(primes,ptrs);
            for (int i = 0; i < m; i++) {
                if (cur % primes[i] == 0) ptrs[i]++;
            }
            res.add(cur);
            p++;
        }
        long r = res.get(p - 1);
        return (int) r;
    }

    private long getMin(int[] primes, int[] ptrs) {
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < primes.length; i++) {
            min = Math.min(min,primes[i] * res.get(ptrs[i]));
        }
        return min;
    }
}