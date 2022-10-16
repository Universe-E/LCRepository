import java.util.HashMap;

class Solution {
    public boolean checkDistances(String s, int[] distance) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) map.put(s.charAt(i),i);
            else map.put(s.charAt(i), i - map.get(s.charAt(i)) - 1);
        }
        for (Character c : map.keySet()) {
            if (distance[c - 'a'] != map.get(c)) return false;
        }
        return true;
    }
}
