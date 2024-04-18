import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;

class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] ss = preorder.split(",");
        var q = new ArrayList<String>();
        for (String s : ss) {
            q.add(q.size(), s);
            int sz = q.size();
            //remove leaf
            while (q.size() >= 3 && q.get(sz - 1).equals("#") && q.get(sz - 2).equals("#") && !q.get(sz - 3).equals("#")) {
                q.remove(q.size() - 1);
                q.remove(q.size() - 1);
                q.remove(q.size() - 1);
                q.add(q.size(), "#");
                sz = q.size();
            }
        }
        return q.size() == 1 && q.get(0).equals("#");
    }
}