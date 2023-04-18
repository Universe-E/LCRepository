import java.util.ArrayList;
import java.util.List;

class Solution {

    public boolean primeSubOperation(int[] nums) {
        List<Integer> primes = new ArrayList<>();
        boolean[] ok = new boolean[1001];
        for (int i = 2; i*i <= 1000; i++) {
            if (!ok[i]) {
                for (int j = 2*i; j <= 1000; j += i) {
                    ok[j] = true;
                }
            }
        }
        for (int i = 2; i <= 1000; i++) {
            if (!ok[i]) primes.add(i);
        }

        int n = nums.length;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= cur) return false;
            int l = 0, r = primes.size()-1;
            while (l < r) {
                int m = (l+r+1) / 2;
                if (primes.get(m) >= nums[i]-cur)
                    r = m-1;
                else l = m;
            }
            if (nums[i] - primes.get(l) > cur)
                nums[i] -= primes.get(l);
            cur = nums[i];
        }
        return true;
    }
}