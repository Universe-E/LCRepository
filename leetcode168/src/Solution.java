class Solution {
    public String convertToTitle(int columnNumber) {
        columnNumber -= 1;
        StringBuilder sb = new StringBuilder();
        while (columnNumber >= 0) {
            int cur = columnNumber%26;
            sb.append((char) ('A'+cur));
            columnNumber = columnNumber/26 - 1;
        }
        return sb.reverse().toString();
    }
}