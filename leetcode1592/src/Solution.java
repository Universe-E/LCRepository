import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String reorderSpaces(String text) {
        int letters = 0;
        List<String> list = new ArrayList<>();
        String[] words = text.split(" ");
        System.out.println(Arrays.toString(words));
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) == ' ') continue;
                String word = words[i].substring(j);
                letters += word.length();
                list.add(word);
                break;
            }
        }
        System.out.println(list.size());
        int spaces = text.length() - letters;
        int val = 0, diff = 0;
        if (list.size() != 1) {
            val = spaces / (list.size() - 1);
            diff = spaces % (list.size() - 1);
        }
        else {
            diff = spaces;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) for (int j = 0; j < val; j++) sb.append(" ");
        }
        for (int i = 0; i < diff; i++) sb.append(" ");
        return sb.toString();
    }
}
