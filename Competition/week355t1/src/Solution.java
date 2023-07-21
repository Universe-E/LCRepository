import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c != separator) sb.append(c);
                else {
                    if (sb.length() != 0) res.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            if (sb.length() != 0) res.add(sb.toString());
        }
        return res;
    }
}

class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        for (String w : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                if (c != separator)
                    sb.append(c);
                else {
                    if (sb.length() != 0)
                        list.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            if (sb.length() != 0)
                list.add(sb.toString());
        }
        return list;
    }
}