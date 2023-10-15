import java.util.Arrays;

class Solution {
    public static final long M = (long) 1e9+7;
    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'R') arr[i] = ((long)nums[i]) + d;
            else arr[i] = ((long)nums[i]) - d;
        }
        Arrays.sort(arr);
        long sum = 0,res = 0;
        for (long num : arr) {
            sum += num;
        }
        for (int i = 0; i < n; i++) {
            sum -= arr[i];
            //注意！这里long也会溢出，因为arr[i]太大！
            res = (res + sum-arr[i]*(n-i-1))%M;
        }
        return (int) (res%M);
    }
}