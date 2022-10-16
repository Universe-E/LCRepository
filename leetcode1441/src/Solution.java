import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int len = target.length;
        int cur = 1;
        for (int i = 0; i < len; i++) {
            while (target[i] != cur) {
                res.add("Push");
                res.add("Pop");
                cur++;
            }
            res.add("Push");
            cur++;
        }
        return res;
    }
}