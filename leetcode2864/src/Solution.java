import java.util.Arrays;

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int cnt = 0,n = s.length();
        for (char c : s.toCharArray()) {
            if (c == '1') cnt++;
        }
        char[] res = new char[n];
        Arrays.fill(res,'0');
        res[n-1] = '1';
        for (int i = 0; i < cnt - 1; i++) {
            res[i] = '1';
        }
        return new String(res);
    }
}