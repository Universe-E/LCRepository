class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] ls = new int[n],rs = new int[n];
        for (int i = 1; i < n-1; i++) {
            if (arr[i] > arr[i-1]) ls[i] = ls[i-1] + 1;
            else ls[i] = 0;
            if (arr[n-i-1] > arr[n-i]) rs[n-i-1] = rs[n-i] + 1;
            else rs[n-i-1] = 0;
        }
        int res = 0;
        for (int i = 1; i < n-1; i++) {
            if (ls[i] != 0 && rs[i] != 0) res = Math.max(res,ls[i]+rs[i]+1);
        }
        return res;
    }
}