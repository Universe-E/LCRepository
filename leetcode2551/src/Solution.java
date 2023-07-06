import java.util.Arrays;

class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        for (int i = 0; i < n - 1; i++) {
            weights[i] += weights[i+1];
        }
        Arrays.sort(weights,0,n-1);
        long res = 0;
        for (int i = 0; i < k - 1; i++) {
            res += weights[n-i-2]-weights[i];
        }
        return res;
    }
}