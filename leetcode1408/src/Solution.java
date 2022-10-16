import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (j == i || words[j].length() > words[i].length()) continue;
                if (words[i].contains(words[j]) && !result.contains(words[j])) result.add(words[j]);
            }
        }
        return result;
        Integer.sum()
    }
}
