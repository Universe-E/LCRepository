class Solution {
    public int findComplement(int num) {
        int res = 0;
        String s = Integer.toBinaryString(num);
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '0') res += 1 << (s.length()-1-i);
        }
        return res;
    }
}