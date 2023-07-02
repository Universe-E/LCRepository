import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //质数
    boolean[] primes;
    int n;
    List<Integer> list;
    private void sievePrime() {
        Arrays.fill(primes,true);
        for (int i = 2; i <= n; i++) {
            for (int j = 2*i; j <= n; j+=i) {
                primes[j] = false;
            }
        }
    }
    public List<List<Integer>> findPrimePairs(int n) {
        this.n = n;
        primes = new boolean[n+1];
        sievePrime();
        list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (primes[i]) list.add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int t = bs(i);
            if (t == -1) continue;;
            if (i <= t) {
                res.add(List.of(list.get(i),list.get(t)));
            }
            else break;
        }
        return res;
    }

    private int bs(int i) {
        int l = i,r = list.size()-1;
        while (l <= r) {
            int m = (l+r)/2;
            int t = list.get(m);
            if (t == n-list.get(i)) return m;
            else if (t > n-list.get(i)) r = m-1;
            else l = m+1;
        }
        return -1;
    }
}
