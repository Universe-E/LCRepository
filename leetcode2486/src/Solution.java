class Solution {
    public int appendCharacters(String s, String t) {
        int l = 0, n = s.length(), n2 = t.length();
        for (int i = 0; i < n; i++) {
            if (l == n2) return 0;
            if (s.charAt(i) == t.charAt(l)) {
                l++;
            }
        }
        return n2-l;
    }
}