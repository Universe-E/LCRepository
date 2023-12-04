import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n1 = word1.length(),n2 = word2.length();
        if (n1 != n2) return false;
        HashMap<Character,Integer> m1 = new HashMap<>(),m2 = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            char c1 = word1.charAt(i),c2 = word2.charAt(i);
            m1.put(c1,m1.getOrDefault(c1,0)+1);
            m2.put(c2,m2.getOrDefault(c2,0)+1);
        }
        if (m1.keySet().size() != m2.keySet().size()) return false;
        for (Character c1 : m1.keySet()) {
            if (!m2.containsKey(c1)) return false;
        }
        ArrayList<Integer> l1 = new ArrayList<>(m1.values()),l2 = new ArrayList<>(m2.values());
        Collections.sort(l1);
        Collections.sort(l2);
        if (l1.size() != l2.size()) return false;
        for (int i = 0; i < l1.size(); i++) {
            if (!Objects.equals(l1.get(i), l2.get(i))) return false;
        }
        return true;
    }
}