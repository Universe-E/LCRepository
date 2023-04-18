import java.util.HashSet;

class Solution {
    public int numDifferentIntegers(String word) {
        int n = word.length();
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            }
            else {
                //NotNull numString will be added
                if (sb.length() > 0) set.add(remove0(sb.toString()));
                sb = new StringBuilder();
            }
        }
        if (sb.length() > 0) {
            set.add(remove0(sb.toString()));
        }
        return set.size();
    }

    private String remove0(String num) {
        int n = num.length();
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) != '0') return num.substring(i);
        }
        return "0";
    }
}