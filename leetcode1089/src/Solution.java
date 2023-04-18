import java.util.Arrays;

class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int diff = 0;
        for (int i = 0; i+diff < n; i++) {
            res[i+diff] = arr[i];
            if (arr[i] == 0) diff++;
        }
        System.arraycopy(res, 0, arr, 0, n);
    }
}