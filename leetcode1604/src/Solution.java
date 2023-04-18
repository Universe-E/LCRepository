import java.util.*;

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, List<String>> m = new HashMap<>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            List<String> ad;
            if (!m.containsKey(keyName[i])) {
                ad = new ArrayList<>();
            }
            else {
                ad = m.get(keyName[i]);
            }
            ad.add(keyTime[i]);
            m.put(keyName[i], ad);
        }
        List<String> res = new ArrayList<>();
        for (String s : m.keySet()) {
            List<String> l = m.get(s);
            if (l.size() >= 3) {
                l.sort((o1, o2) -> {
                    Integer h1 = Integer.parseInt(o1.substring(0, 2)),
                            h2 = Integer.parseInt(o2.substring(0, 2)),
                            m1 = Integer.parseInt(o1.substring(3)),
                            m2 = Integer.parseInt(o2.substring(3));
                    return h1.equals(h2) ? (m1 - m2) : (h1 - h2);
                });
                for (int i = 2; i < l.size(); i++) {
                    int h1 = Integer.parseInt(l.get(i).substring(0, 2)),
                            h2 = Integer.parseInt(l.get(i-2).substring(0, 2)),
                            m1 = Integer.parseInt(l.get(i).substring(3)),
                            m2 = Integer.parseInt(l.get(i-2).substring(3));
                    if ((double)(m1-m2)/60 + h1-h2 <= 1.0) {
                        res.add(s);
                        break;
                    }
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}