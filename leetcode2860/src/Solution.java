import java.util.Comparator;
import java.util.List;

class Solution {
    public int countWays(List<Integer> nums) {
        int n = nums.size(), res = 0;
        nums.sort(Comparator.comparingInt(o -> o));
        if (nums.get(0) > 0) res++;
        if (n > nums.get(n-1)) res++;
        for (int i = 0; i < n-1; i++) {
            if (i+1 > nums.get(i) && nums.get(i+1) > i+1) res++;
        }
        return res;
    }
}