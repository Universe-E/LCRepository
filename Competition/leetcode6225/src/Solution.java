import java.util.*;

class Solution {
    public String oddString(String[] words) {
        int n = words.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            List<Integer> diff = new ArrayList<>();
            for (int j = 1; j < word.length(); j++) {
                diff.add(word.charAt(j) - word.charAt(j-1));
            }
            map.put(i,diff);
        }
        List<Integer> lT = new ArrayList<>(),lF = new ArrayList<>();
        List<Integer> cur = map.get(0);
        for (Integer idx : map.keySet()) {
            List<Integer> l = map.get(idx);
            if (isEquals(cur,l)) lT.add(idx);
            else lF.add(idx);
        }
        if (lT.size() == 1) return words[lT.get(0)];
        else return words[lF.get(0)];
    }

    private boolean isEquals(List<Integer> l1,List<Integer> l2) {
        int n = l1.size();
        for (int i = 0; i < n; i++) {
            if (!l1.get(i).equals(l2.get(i))) return false;
        }
        return true;
    }
}