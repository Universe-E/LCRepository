import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public String alienOrder(String[] words) {
        int n = words.length;
        if (n == 1) {
            HashSet<Character> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (char c : words[0].toCharArray()) {
                if (set.contains(c)) continue;
                sb.append(c);
                set.add(c);
            }
            return sb.toString();
        }
        List<List<Character>> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            String pre = words[i-1], cur = words[i];
            for (int j = 0; j < Math.min(pre.length(),cur.length());j++){
                char c1 = pre.charAt(j), c2 = cur.charAt(j);
                if (c1 != c2) {
                    boolean merge = false;
                    for (List<Character> cl : list) {
                        if (!cl.contains(c1) && !cl.contains(c2)) break;
                        //if c1 and c2 are already sorted, check the correct sequence
                        if (cl.contains(c1) && cl.contains(c2) && cl.get(c1) > cl.get(c2)) return "";
                        //merge two char lists,addFirst or addLast
                        //eg: [w,e]+cl:[e,f]->[w,e,f]
                        if (cl.get(0) == c2) {
                            cl.add(0, c1);
                            merge = true;
                            break;
                        }
                        //eg: [r,t]+cl:[e,r]->[e,r,t]
                        else if (cl.get(cl.size() - 1) == c1) {
                            cl.add(c2);
                            merge = true;
                            break;
                        }
                    }
                    //no matching lists
                    if (!merge) {
                        List<Character> ll = new ArrayList<>();
                        ll.add(c1);
                        ll.add(c2);
                        list.add(ll);
                    }
                    break;
                }

            }
        }

    }
}