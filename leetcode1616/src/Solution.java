class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return check2(a,b) || check2(b,a);
    }

    private boolean check1(String s) {
        int n = s.length();
        int l = 0,r = n-1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        if (n%2 == 0) return l == r+1;
        else return l == r;
    }

    private boolean check2(String a,String b) {
        int n = a.length(),l = 0,r = n-1;
        while (l < r) {
            char ac = a.charAt(l), bc = b.charAt(r);
            if (ac == bc) {
                l++;
                r--;
            }
            else break;
        }
        if (l >= r) return true;
        return check1(a.substring(l,r+1)) || check1(b.substring(l,r+1));
    }
}