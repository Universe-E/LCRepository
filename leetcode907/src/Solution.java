class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            //找到arr[i]能够作为最小值的数组左右边界l和r，相应的子数组数量等于(i - l) * (r - i)
            int l = i - 1,r = i + 1;
            while (l >= 0 && arr[i] < arr[l]) l--;
            while (r < n && arr[i] <= arr[r]) r++;
            res += (long) (i - l) * (r - i) * arr[i];
        }
        return (int) (res % 1000000007);
    }
}