class Solution {
    public int bestClosingTime(String customers) {
        int len = customers.length(),y = 0;
        for (int i = 0; i < len; i++) {
            if (customers.charAt(i) == 'Y') y++;
        }
        int cur = y,n = 0,res = 0;
        for (int i = 1; i <= len; i++) {
            if (customers.charAt(i-1) == 'Y') y--;
            else n++;
            if (y+n < cur) {
                cur = y+n;
                res = i;
            }
        }
        return res;
    }
}