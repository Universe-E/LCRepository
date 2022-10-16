class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--)
            res += (int) (Math.pow(26,columnTitle.length() - i - 1) * (columnTitle.charAt(i) - 'A' + 1));
        return res;
    }
}
