import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    List<Integer> res = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    public List<Integer> circularPermutation(int n, int start) {
        res.add(start);
        set.add(start);
        for (int i = 1; i < 1<<n; i++) {
            modify(n,res.get(res.size()-1));
        }
        return res;
    }

    private void modify(int n,int num) {
        for (int i = 0; i < n; i++) {
            int cur = (num >> i) & 1;
            int temp = num + (cur==0 ? (1<<i) : -(1<<i));
            if (!set.contains(temp)) {
                res.add(temp);
                set.add(temp);
                return;
            }
        }
    }
}