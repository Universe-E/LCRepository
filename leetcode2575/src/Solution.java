class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        long r = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            r = ((long) 10 * r + (word.charAt(i)-'0')) % m;
            if (r == 0) res[i] = 1;
        }
        return res;
    }
}