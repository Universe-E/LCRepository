import java.util.HashMap;

class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String,Integer> map = new HashMap<>();
        int n = messages.length;
        for (int i = 0; i < n; i++) {
            String[] mes = messages[i].split(" ");
            if (!map.containsKey(senders[i])) map.put(senders[i],mes.length);
            else map.put(senders[i], map.get(senders[i]) + mes.length);
        }
        String key = "";
        int res = 0;
        for (String s : map.keySet()) {
            if (map.get(s) > res) {
                res = map.get(s);
                key = s;
            }
            else if (map.get(s) == res) {
                if (s.compareTo(key) > 0) key = s;
            }
        }
        return key;
    }
}