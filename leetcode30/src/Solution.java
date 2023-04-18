import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        int m = words.length, wm = words[0].length(), n = s.length();
        for (int i = 0; i + m*wm <= n; i++) {
            //the copy of map
            HashMap<String,Integer> map2 = new HashMap<>(map);
            int j = i;
            while (j < i + m*wm) {
                String ss = s.substring(j,j+wm);
                //invalid substring
                if (!map2.containsKey(ss)) break;
                map2.put(ss, map2.get(ss)-1);
                if (map2.get(ss) == 0) map2.remove(ss);
                j += wm;
            }
            if (j == i+m*wm && map2.isEmpty()) res.add(i);
        }
        return res;
    }
}
