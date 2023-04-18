class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //差分数组
        int[] diff = new int[1005];
        for (int[] trip : trips) {
            int num = trip[0], from = trip[1], to = trip[2];
            diff[from] += num;
            diff[to] -= num;
        }
        int cur = 0;
        for (int i = 0; i < 1005; i++) {
            cur += diff[i];
            if (cur > capacity) return false;
        }
        return true;
    }
}