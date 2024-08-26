class Solution {
    public int minimumLevels(int[] possible) {
        int n = possible.length, sum = 0;
        for (int i = 0; i < n; i++) {
            if (possible[i] == 0) possible[i] = -1;
            sum += possible[i];
        }
        int a = 0;
        for (int i = 0; i < n-1; i++) {
            a += possible[i];
            if (a > sum-a) return i+1;
        }
        return -1;
    }
}