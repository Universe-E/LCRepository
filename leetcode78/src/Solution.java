import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> cur = new ArrayList<>(res.get(j));
                cur.add(num);
                res.add(cur);
            }
        }
        return res;
    }
}
