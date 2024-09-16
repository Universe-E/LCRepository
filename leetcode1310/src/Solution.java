class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] xor = new int[n+1];
        for (int i = 0; i < n; i++) {
            xor[i+1] = xor[i] ^ arr[i];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = xor[queries[i][1]+1] ^ xor[queries[i][0]];
        }
        return res;
    }
}