class Solution {
    public int countDigits(int num) {
        int cnt = 0;
        char[] cs = String.valueOf(num).toCharArray();
        int n = cs.length;
        for (char c : cs) {
            if (num % (c - '0') == 0) cnt++;
        }
        return cnt;
    }
}