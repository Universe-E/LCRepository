class Solution {
    public String largestOddNumber(String num) {
        int n = num.length(),r = n;
        for (int i = n-1; i >= 0; i--) {
            if ((num.charAt(i)-'0') % 2 != 0) {
                r = i;
                break;
            }
        }
        return r == n ? "" : num.substring(0,r+1);
    }
}