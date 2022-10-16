import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            List<String> list;
            if (!map.containsKey(key)) list = new ArrayList<>();
            else list = map.get(key);
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
