class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int l = 0, r = n-1;
        while (l < r) {
            char cl = s.charAt(l), cr = s.charAt(r);
            if (cl == cr) {
                while (l < n && s.charAt(l) == cl) l++;
                while (r >= 0 && s.charAt(r) == cr) r--;
            }
            else break;
        }
        return Math.max(0,r-l+1);
    }
}