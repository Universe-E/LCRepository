class Solution {
    public int minOperations(int n) {
        int ceil = 1;
        while (ceil < n) {
            ceil *= 2;
        }
        if (ceil == n) return 1;
        int diff1 = n - ceil/2, diff2 = ceil - n;
        int l = 1 + minOperations(diff1);
        int r = 1 + minOperations(diff2);
        return Math.min(l,r);
    }

    public static void main(String[] args) {
        int n = 870;
        System.out.println(new Solution().minOperations(n));
    }
}