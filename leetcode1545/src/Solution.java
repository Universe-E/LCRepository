import java.util.Scanner;

class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        if (k == Math.pow(2,n - 1)) return '1';
        return findKthString(n).charAt(k - 1);
    }

    private String findKthString(int n) {
        if (n == 1) return "0";
        String last = findKthString(n - 1);
        StringBuilder invert = new StringBuilder();
        for (int i = last.length() - 1; i >= 0; i--) {
            invert.append((last.charAt(i) - '0') ^ 1);
        }
        return last + "1" + invert.toString();
    }
}