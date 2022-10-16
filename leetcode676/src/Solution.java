class MagicDictionary {
    boolean isWord;
    MagicDictionary[] children;

    public MagicDictionary() {
        isWord = false;
        children = new MagicDictionary[26];
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            MagicDictionary root = this;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (root.children[i] == null) root.children[i] = new MagicDictionary();
                root = root.children[i];
            }
            root.isWord = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(searchWord,0,0,this);
    }

    private boolean dfs(String word,int wrong,int start,MagicDictionary root) {
        if (start == word.length()) return wrong == 1 && root.isWord;
        int i = word.charAt(start) - 'a';
        if (root.children[i] != null) {
            if (dfs(word,wrong,start + 1,root.children[i])) return true;
        }
        //在当前层没有找到相应的i，且此时wrong没有修改过，如果wrong已经修改过，直接跳过返回false即可（不止一处wrong）
        if (wrong == 0) {
            for (int j = 0; j < 26; j++) {
                if (j != i && root.children[j] != null) {
                    //这里将wrong自增为1
                    wrong++;
                    if (dfs(word,wrong,start + 1,root.children[j])) return true;
                }
            }
        }
        return false;
    }
}
