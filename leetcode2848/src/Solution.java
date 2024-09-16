import java.util.Comparator;
import java.util.List;
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        nums.sort(Comparator.comparingInt(o -> o.get(0)));
        int res = 0, bound = 0;
        for (List<Integer> num : nums) {
            int l = num.get(0), r = num.get(1);
            if (r > bound) {
                if (l <= bound) res += r-bound;
                else res += r-l+1;
                bound = r;
            }
        }
        return res;
    }
}