import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> resList = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 9; i < s.length(); i++) {
            String cur = s.substring(i - 9,i + 1);
            if (!map.containsKey(cur)) map.put(cur,1);
            else map.put(cur, map.get(cur) + 1);
        }
        for (String s1 : map.keySet()) {
            if (map.get(s1) > 1) resList.add(s1);
        }
        return resList;
    }
}
