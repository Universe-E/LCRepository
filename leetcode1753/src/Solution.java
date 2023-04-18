import java.util.Arrays;

class Solution {
    public int maximumScore(int a, int b, int c) {
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        if (arr[0] + arr[1] <= arr[2]) return arr[0] + arr[1];
        return (arr[0] + arr[1] - arr[2]) / 2 + arr[2];
    }
}