import java.util.HashSet;

class Solution {
    static HashSet<Character> cs = new HashSet<>();
    static {
        for (int i = 0; i < 26; i++) {
            cs.add((char)('a'+i));
            cs.add((char)('A'+i));
        }
        cs.add('@');
        cs.add('.');
    }
    public String maskPII(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        if (cs.contains(s.charAt(0))) {
            int i = 0;
            while (s.charAt(i) != '@') i++;
            sb.append(Character.toLowerCase(s.charAt(0)));
            for (int j = 0; j < 5; j++) {
                sb.append('*');
            }
            sb.append(Character.toLowerCase(s.charAt(i-1)));
            while (i < n) {
                char c = s.charAt(i);
                if (Character.isLetter(c)) sb.append(Character.toLowerCase(c));
                else sb.append(c);
                i++;
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                if (Character.isDigit(s.charAt(i))) sb.append(s.charAt(i));
            }
            int len = sb.length();
            String last4 = sb.substring(len-4);
            sb = new StringBuilder();
            if (len == 10) sb.append("***-***-").append(last4);
            else if (len == 11) sb.append("+*-***-***-").append(last4);
            else if (len == 12) sb.append("+**-***-***-").append(last4);
            else sb.append("+***-***-***-").append(last4);
        }
        return sb.toString();
    }
}