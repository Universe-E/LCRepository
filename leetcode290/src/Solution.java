import java.util.ArrayList;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        //数组编号与单词一一对应
        String[] ss = s.split(" ");
        if (ss.length != pattern.length()) return false;
        String[] words = new String[26];
        int p = 0;
        for (int i = 0; i < pattern.length(); i++) {
            StringBuilder sb = new StringBuilder();
            while (p < s.length()) {
                if (s.charAt(p) == ' ') {
                    p++;
                    break;
                }
                sb.append(s.charAt(p));
                p++;
            }
            int wordsIndex = pattern.charAt(i) - 'a';
            String word = sb.toString();
            if (words[wordsIndex] == null) words[wordsIndex] = word;
            else if (!words[wordsIndex].equals(word)) return false;
        }
        //words中不应包含重复元素
        ArrayList<String> list = new ArrayList<>();
        for (String word : words) {
            if (word == null) continue;
            if (list.contains(word)) return false;
            list.add(word);
        }
        return true;
    }
}