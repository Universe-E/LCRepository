import java.util.Arrays;

class Solution {
    public int splitNum(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        Arrays.sort(cs);
        int num1 = 0, num2 = 0, b = 1;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '0') continue;
            if (b == 1) {
                num1 = num1*10 + cs[i] - '0';
                b = 0;
            }
            else {
                num2 = num2*10 + cs[i] - '0';
                b = 1;
            }
        }
        return num1 + num2;
    }
}