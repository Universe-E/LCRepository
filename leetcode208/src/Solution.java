class Trie {
    boolean isWord;
    Trie[] children;

    public Trie() {
        isWord = false;
        children = new Trie[26];
    }

    public void insert(String word) {
        Trie root = this;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (root.children[i] == null) root.children[i] = new Trie();
            root = root.children[i];
        }
        root.isWord = true;
    }

    public boolean search(String word) {
        Trie root = findPrefix(word);
        return root != null && root.isWord;
    }

    public boolean startsWith(String prefix) {
        return findPrefix(prefix) != null;
    }

    //找单词和找前缀本质上是同一个方法
    private Trie findPrefix(String word) {
        Trie root = this;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (root.children[i] == null) return null;
            root = root.children[i];
        }
        return root;
    }
}