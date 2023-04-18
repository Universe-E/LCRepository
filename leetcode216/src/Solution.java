import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        bt(1,0,k,n);
        return res;
    }

    private void bt(int i, int cnt, int k, int n) {
        if (cnt == k) {
            if (n == 0) res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j + (k-cnt)-1 <= 9; j++) {
            list.add(j);
            bt(j+1,cnt+1,k,n-j);
            list.remove(list.size() - 1);
        }
    }
}