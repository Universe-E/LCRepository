class Solution {
    public int nextBeautifulNumber(int n) {
        for (int i = n+1; i <= 1224444; i++) {
            if (isBalance(i)) return i;
        }
        return -1;
    }

    private boolean isBalance(int n) {
        int[] cnt = new int[10];
        while (n > 0) {
            cnt[n % 10]++;
            n /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (cnt[i] > 0 && cnt[i] != i) return false;
        }
        return true;
    }
}