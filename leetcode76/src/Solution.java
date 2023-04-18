import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>(), map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        //l represents the first unmatched left bound
        int n = s.length(), l = 0, res = n;
        String ss = "";
        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);
            map2.put(c,map2.getOrDefault(c,0)+1);
            while (l <= r && isValid(map,map2)) {
                char lc = s.charAt(l);
                map2.put(lc,map2.get(lc)-1);
                if (map2.get(lc) == 0) map2.remove(lc);
                l++;
            }
            if (l != 0 && r-l+2 <= res) {
                res = r-l+2;
                ss = s.substring(l-1,r+1);
            }
        }
        return ss;
    }

    private boolean isValid(HashMap<Character, Integer> map, HashMap<Character, Integer> map2) {
        for (Character k : map.keySet()) {
            if (map2.getOrDefault(k,0) < map.get(k)) return false;
        }
        return true;
    }

}