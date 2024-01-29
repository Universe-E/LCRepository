import java.util.HashMap;

class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String,Integer> map1 = new HashMap<>(),map2 = new HashMap<>();
        for (String w : words1) {
            map1.put(w,map1.getOrDefault(w,0)+1);
        }
        for (String w : words2) {
            map2.put(w,map2.getOrDefault(w,0)+1);
        }
        int res = 0;
        for (String w : map1.keySet()) {
            if (map1.get(w) == 1 && map2.containsKey(w) && map2.get(w) == 1) res++;
        }
        return res;
    }
}