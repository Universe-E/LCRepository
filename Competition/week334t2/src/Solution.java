class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] res = new int[n];
        long j = 0;
        for (int i = 0; i < n; i++) {
            j = (j*10+(word.charAt(i)-'0'))%m;
            if (j == 0) res[i] = 1;
        }
        return res;
    }
}