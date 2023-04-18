import java.util.HashSet;

class Solution {
    private static final char[] CS = {'!','@','#','$','%','^','&','*','(',')','-','+'};
    private static final HashSet<Character> SET = new HashSet<>();
    static {
        for (char c : CS) {
            SET.add(c);
        }
    }

    
    public boolean strongPasswordCheckerII(String password) {
        int n = password.length();
        if (n < 8) return false;
        boolean b1 = false, b2 = false, b3 = false, b4 = false;
        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);
            if (i != 0 && c == password.charAt(i-1)) return false;
            if (Character.isDigit(c)) b1 = true;
            else if (Character.isLowerCase(c)) b2 = true;
            else if (Character.isUpperCase(c)) b3 = true;
            else if (SET.contains(c)) b4 = true;
        }
        return b1 && b2 && b3 && b4;
    }
}