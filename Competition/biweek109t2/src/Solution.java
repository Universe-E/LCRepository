import java.util.*;

class Solution {
    static HashSet<Character> set = new HashSet<>();
    static {
        Character[] cc = new Character[] {'a','e','i','o','u','A','E','I','O','U'};
        set.addAll(List.of(cc));
    }
    public String sortVowels(String s) {
        int n = s.length();
        ArrayList<Character> volist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) volist.add(c);
        }
        Collections.sort(volist);
        char[] cs = s.toCharArray();
        for (int i = 0,id = 0; i < n; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                cs[i] = volist.get(id++);
            }
        }
        return new String(cs);
    }
}