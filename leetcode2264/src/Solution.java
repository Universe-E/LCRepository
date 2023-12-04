class Solution {
    public String largestGoodInteger(String num) {
        for (int i = 9; i >= 0; i--) {
            String ss = i + String.valueOf(i) + i;
            if (num.contains(ss)) return ss;
        }
        return "";
    }
}