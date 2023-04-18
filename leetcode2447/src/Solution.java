class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i; j >= 0; j--) {
                g = gcd(g,nums[j]);
                // g must be the multiple of k
                if (g % k != 0) break;
                if (g == k) res++;
            }
        }
        return res;
    }
    private int gcd(int p,int q) {
        while (q != 0) {
            int temp = p % q;
            p = q;
            q = temp;
        }
        return p;
    }
}