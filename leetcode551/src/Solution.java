class Solution {
    public boolean checkRecord(String s) {
        int a = 0, l = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                a++;
                l = 0;
            }
            else if (c == 'L') l++;
            else l = 0;
            if (l >= 3 || a == 2) return false;
        }
        return true;
    }
}