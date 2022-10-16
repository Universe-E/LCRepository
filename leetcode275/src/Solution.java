class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] < n - i) break;
            res = Math.max(res,Math.min(n - i,citations[i]));
        }
        return res;
    }
}
