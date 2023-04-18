class Solution {
    public int repeatedStringMatch(String a, String b) {
        int an = a.length(), bn = b.length();
        int index = strStr(a, b);
        if (index == -1) {
            return -1;
        }
        if (an - index >= bn) {
            return 1;
        }
        return (bn + index - an - 1) / an + 2;
    }

    public int strStr(String a, String b) {
        int n = a.length(), m = b.length();
        if (m == 0) return 0;
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && b.charAt(i) != b.charAt(j)) {
                j = pi[j - 1];
            }
            if (b.charAt(i) == b.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i - j < n; i++) { // b 开始匹配的位置是否超过第一个叠加的 a
            while (j > 0 && a.charAt(i % n) != b.charAt(j)) { // a 是循环叠加的字符串，所以取 i % n
                j = pi[j - 1];
            }
            if (a.charAt(i % n) == b.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}