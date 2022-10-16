class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = i - 1, k = i + 1;
            while (j >= 0) {
                if (s.charAt(j) == s.charAt(i)) break;
                j--;
            }
            while (k < n) {
                if (s.charAt(k) == s.charAt(i)) break;
                k++;
            }
            res += (i - j) * (k - i);
        }
        return res;
    }
}
