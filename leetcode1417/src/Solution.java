import java.util.ArrayList;
import java.util.List;

class Solution {
    public String reformat(String s) {
        List<Character> charList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) intList.add(s.charAt(i) - '0');
            else if (Character.isAlphabetic(s.charAt(i))) charList.add(s.charAt(i));
        }
        if (Math.abs(intList.size() - charList.size()) > 1) return "";
        StringBuilder sb = new StringBuilder();
        int size1 = charList.size(), size2 = intList.size();
        while (!(charList.isEmpty() && intList.isEmpty())) {
            if (size1 > size2) {
                if (!charList.isEmpty()) sb.append(charList.remove(0));
                if (!intList.isEmpty()) sb.append(intList.remove(0));
            }
            else {
                if (!intList.isEmpty()) sb.append(intList.remove(0));
                if (!charList.isEmpty()) sb.append(charList.remove(0));
            }
        }
        return sb.toString();
    }
}
