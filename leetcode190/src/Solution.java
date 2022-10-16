public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        int abs = 0;
        for (int i = Math.min(31,s.length() - 1); i >= 0; i--) {
            abs += (s.charAt(i) - '0') * (1 << (i + 32 - s.length()));
        }
        return abs;
    }
}