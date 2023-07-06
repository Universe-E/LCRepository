class Solution {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n+2];
        //预处理差分数组
        for (int i = 0; i <= n; i++) {
            if (i == 0) arr[i+1] = nums[0];
            else if (i == n) arr[i+1] = -nums[i-1];
            else arr[i+1] = nums[i]-nums[i-1];
        }
        for (int i = 0; i < n+2-k; i++) {
            if (arr[i] != 0) {
                arr[i+k] += arr[i];
                //可以将arr[i]置0省略
            }
        }
        //后续不考虑n+2-k之前的元素，因为前面已经置为0
        for (int i = n+2-k; i < n + 2; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }
}