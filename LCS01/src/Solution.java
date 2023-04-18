class Solution {
    public int leastMinutes(int n) {
        if (n == 1) return 1;
        int base = 1, res = 0;
        while (base < n) {
            base *= 2;
            res++;
        }
        return res + 1;
    }
}