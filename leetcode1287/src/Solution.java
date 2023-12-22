class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length,cur = 0,cnt = 0;
        for (int j : arr) {
            if (j != cur) {
                cur = j;
                cnt = 1;
            }
            else cnt++;
            if (cnt > n / 4) return cur;
        }
        return -1;
    }
}