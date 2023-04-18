import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTrack(n,new ArrayList<>(),1,k);
        return res;
    }

    private void backTrack(int n, List<Integer> list, int p, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = p; i <= n; i++) {
            list.add(i);
            backTrack(n,list,i+1,k-1);
            list.remove(list.size() - 1);
        }
    }
}