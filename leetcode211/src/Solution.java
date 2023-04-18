class WordDictionary {

    private class Trie {
        Trie[] children;
        boolean isWord;

        public Trie() {
            children = new Trie[26];
            isWord = false;
        }

        public void insert(String word) {
            Trie t = this;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (t.children[idx] == null) {
                    t.children[idx] = new Trie();
                }
                t = t.children[idx];
            }
            t.isWord = true;
        }

    }

    Trie t;
    public WordDictionary() {
        t = new Trie();
    }

    public void addWord(String word) {
        t.insert(word);
    }

    public boolean search(String word) {
        return dfs(word,0,t);
    }
    private boolean dfs(String word, int idx, Trie tree) {
        if (idx == word.length()) return tree.isWord;
        char c = word.charAt(idx);
        if (c != '.') {
            if (tree.children[c - 'a'] == null) return false;
            return dfs(word,idx+1,tree.children[c - 'a']);
        }
        else {
            for (int i = 0; i < 26; i++) {
                //find the matched solution skip the null
                if (tree.children[i] == null) continue;
                if (dfs(word,idx+1,tree.children[i])) return true;
            }
            //all index cannot match
            return false;
        }
    }
}