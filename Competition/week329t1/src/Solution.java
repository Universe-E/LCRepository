class Solution {
    public int alternateDigitSum(int n) {
        int res = 0;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            if (i%2==0) res += s.charAt(i)-'0';
            else res -= s.charAt(i) - '0';
        }
        return res;
    }
}