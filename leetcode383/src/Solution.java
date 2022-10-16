import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if (!map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i), 1);
            }
            else {
                int value = map.get(magazine.charAt(i));
                map.put(magazine.charAt(i),value + 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!map.containsKey(ransomNote.charAt(i))) return false;
            if (map.get(ransomNote.charAt(i)) == 0) return false;
            int value = map.get(ransomNote.charAt(i));
            map.put(ransomNote.charAt(i), value - 1);
        }
        return true;
    }
}
