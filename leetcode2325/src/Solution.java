import java.util.Arrays;

class Solution {
    public String decodeMessage(String key, String message) {
        int[] code = new int[26];
        Arrays.fill(code, -1);
        int idx = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c != ' ') {
                if (code[c-'a'] == -1) code[c-'a'] = idx++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == ' ') sb.append(c);
            else sb.append((char) (code[c - 'a'] + 'a'));
        }
        return sb.toString();
    }
}