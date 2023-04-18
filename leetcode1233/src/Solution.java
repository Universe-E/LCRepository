import java.util.*;

class Trie{
    boolean isWord;
    int index;
    HashMap<String,Trie> children;
    public Trie() {
        isWord = false;
        index = -1;
        children = new HashMap<>();
    }
}
class Solution {
    Trie t = new Trie();
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < folder.length; i++) {
            insert(folder[i],i);
        }
        //bfs
        ArrayDeque<Trie> ad = new ArrayDeque<>();
        //add all the children Trie to the ad
        for (String k : t.children.keySet()) {
            ad.addLast(t.children.get(k));
        }
        while (!ad.isEmpty()) {
            Trie cur = ad.pollFirst();
            //if cur is word, then add to the result list, or bfs its children
            if (cur.isWord) {
                res.add(folder[cur.index]);
            }
            else for (String k : cur.children.keySet()) {
                ad.addLast(cur.children.get(k));
            }
        }
        return res;
    }

    public void insert(String w,int index) {
        Trie cur = t;
        for (String f : w.split("/")) {
            if (f.length() == 0) continue;
            if (!cur.children.containsKey(f)) {
                cur.children.put(f,new Trie());
            }
            cur = cur.children.get(f);
        }
        cur.isWord = true;
        cur.index = index;
    }
}