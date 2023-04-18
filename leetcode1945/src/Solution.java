class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }
        String ss = sb.toString();
        int res = 0;
        while (k > 0) {
            int cur = 0;
            for (char c : ss.toCharArray()) {
                cur += c - '0';
            }
            ss = String.valueOf(cur);
            res = cur;
            k--;
        }
        return res;
    }
}