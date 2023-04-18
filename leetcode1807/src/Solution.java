import java.util.List;
import java.util.TreeMap;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        TreeMap<String,String> map = new TreeMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0),list.get(1));
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        boolean open = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!open && c != '(') {
                res.append(c);
            }
            else if (c == '(') open = true;
            else if (Character.isLetter(c)) sb.append(s.charAt(i));
            else if (s.charAt(i) == ')') {
                String key = sb.toString();
                if (map.containsKey(key)) res.append(map.get(key));
                else res.append('?');
                sb = new StringBuilder();
                open = false;
            }
        }
        return res.toString();
    }
}