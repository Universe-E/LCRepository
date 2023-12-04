import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        int n = arr.length,res = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i]-arr[i-1] > 1) {
                arr[i] = arr[i-1]+1;
            }
            res = Math.max(res,arr[i]);
        }
        return res;
    }
}