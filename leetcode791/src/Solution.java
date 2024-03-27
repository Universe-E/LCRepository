import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public String customSortString(String order, String s) {
        char[] letters = order.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < letters.length; i++) {
            map.put(letters[i],i);
        }
        Character[] res = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = s.charAt(i);
        }
        Arrays.sort(res, (o1, o2) -> {
            if (map.containsKey(o1) && map.containsKey(o2)) return map.get(o1) - map.get(o2);
            else if (!map.containsKey(o1) && !map.containsKey(o2)) return 0;
            else return map.containsKey(o1) ? -1 : 1;
        });
        StringBuilder sb = new StringBuilder();
        for (Character re : res) {
            sb.append(re);
        }
        return sb.toString();
    }
}

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char o = order.charAt(i);
            while (map.containsKey(o) && map.put(o, map.get(o)-1) > 0) {
                sb.append(o);
            }
        }
        for (Character c : map.keySet()) {
            sb.append(String.valueOf(c).repeat(Math.max(0, map.get(c))));
        }
        return sb.toString();
    }
}