class StreamChecker {
    Trie t;
    StringBuilder sb;
    public StreamChecker(String[] words) {
        t = new Trie();
        sb = new StringBuilder();
        for (String word : words) {
            t.add(word);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        return t.query(sb);
    }
}

class Trie {
    boolean isWord;
    Trie[] c;

    public Trie() {
        isWord = false;
        c = new Trie[26];
    }

    public void add(String word) {
        Trie t = this;
        for (int i = word.length() - 1; i >= 0; i--) {
            int idx = word.charAt(i) - 'a';
            if (t.c[idx] == null) t.c[idx] = new Trie();
            t = t.c[idx];
        }
        t.isWord = true;
    }

    public boolean query(StringBuilder sb) {
        Trie t = this;
        for (int i = sb.length() - 1,j = 0; i >= 0 && j <= 200; i--,j++) {
            int idx = sb.charAt(i) - 'a';
            if (t.c[idx] == null) return false;
            t = t.c[idx];
            if (t.isWord) return true;
        }
        return false;
    }
}