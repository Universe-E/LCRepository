class TrieNode {
    int val;
    TrieNode[] children = new TrieNode[26];
}

class Solution {
    private final TrieNode root = new TrieNode();
    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] res = new int[n];
        for (String word : words) {
            insert(word);
        }
        for (int i = 0; i < n; i++) {
            res[i] = query(words[i]);
        }
        return res;
    }

    //往字典树中插入单词
    public void insert(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (p.children[i] == null) p.children[i] = new TrieNode();
            //注意，每个字母途径的节点值需要加1
            p.children[i].val += 1;
            //更新p
            p = p.children[i];
        }
    }

    //当前单词每个前缀的分数总和
    public int query(String word) {
        TrieNode p = root;
        int res = 0;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (p.children[i] == null) return res;
            res += p.children[i].val;
            p = p.children[i];
        }
        return res;
    }
}