class Solution {
    public boolean isFascinating(int n) {
        String s = String.valueOf(n) +
                2 * n +
                3 * n;
        int[] cnt = new int[10];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)-'0']++;
        }
        for (int i = 0; i < 10; i++) {
            if (cnt[0] != 0) return false;
            if (i != 0 && cnt[i] != 1) return false;
        }
        return true;
    }
}