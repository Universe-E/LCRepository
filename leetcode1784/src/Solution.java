class Solution {
    public boolean checkOnesSegment(String s) {
        if (!s.contains("1")) return true;
        int n = s.length();
        int times = 0;
        boolean valid = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1' && !valid) {
                times++;
                valid = true;
            }
            if (s.charAt(i) == '0') times = 0;
            if (s.charAt(i) == '1' && times == 0 && valid) return false;
        }
        return true;
    }
}