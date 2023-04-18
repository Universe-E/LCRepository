class Solution {
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        String s = Integer.toBinaryString(n);
        int sn = s.length(), i = sn-1;
        while (i >= 0) {
            if (s.charAt(i) == '1') {
                res[(sn-i-1)%2]++;
            }
            i--;
        }
        return res;
    }
}