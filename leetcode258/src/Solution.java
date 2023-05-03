class Solution {
    public int addDigits(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        if (n == 1) return num;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += s.charAt(i) - '0';
        }
        return addDigits(res);
    }
}