import java.util.Arrays;

class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int diff = n / 20;
        double sum = 0;
        for (int i = diff; i < n - diff; i++) {
            sum += arr[i];
        }
        return sum / (n - 2 * diff);
    }
}
