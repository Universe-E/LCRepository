import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static final String[] pool = {"qwertyuiop","asdfghjkl","zxcvbnm"};
    public String[] findWords(String[] words) {
        HashMap<Integer,List<Character>> map = new HashMap<>();
        for (int i = 0; i < pool.length; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < pool[i].length(); j++) {
                list.add(pool[i].charAt(j));
            }
            map.put(i,list);
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            List<Character> cur = new ArrayList<>();
            String w = word.toLowerCase();
            for (List<Character> list : map.values()) {
                if (list.contains(w.charAt(0))) {
                    cur = list;
                    break;
                }
            }
            boolean isValid = true;
            for (int i = 1; i < w.length(); i++) {
                if (!cur.contains(w.charAt(i))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) res.add(word);
        }
        String[] ress = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ress[i] = res.get(i);
        }
        return ress;
    }
}
