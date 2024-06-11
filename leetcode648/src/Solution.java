import java.util.List;
class Trie {
    boolean isWord;
    Trie[] children = new Trie[26];
}
class Solution {
    Trie root = new Trie();
    public String replaceWords(List<String> dictionary, String sentence) {
        for (String s : dictionary) {
            insert(s);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(setPrefix(words[i]));
            if (i != words.length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    private void insert(String word) {
        Trie p = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (p.children[i] == null) p.children[i] = new Trie();
            p = p.children[i];
        }
        p.isWord = true;
    }

    //找到前缀并返回，如果没有前缀则直接返回该单词
    private String setPrefix(String word) {
        Trie p = root;
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (p.children[i] == null) return word;
            sb.append(c);
            if (p.children[i].isWord) return sb.toString();
            p = p.children[i];
        }
        return word;
    }
}
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            sb.append(manage(word,dictionary));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private String manage(String word, List<String> dictionary) {
        int len = word.length();
        String res = word;
        for (String s : dictionary) {
            if (word.startsWith(s)) {
                if (s.length() < len) {
                    len = s.length();
                    res = s;
                }
            }
        }
        return res;
    }
}