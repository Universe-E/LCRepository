import java.util.Arrays;

class Solution {
    public int countVowelStrings(int n) {
        int[] arr = new int[5];
        Arrays.fill(arr,1);
        for (int i = 2; i <= n; i++) {
            int[] pre = Arrays.copyOf(arr,5);
            for (int j = 1; j < 5; j++) {
                arr[j] += arr[j-1];
            }
        }
        int res = 0;
        for (int i = 0; i < 5; i++) {
            res += arr[i];
        }
        return res;
    }
}