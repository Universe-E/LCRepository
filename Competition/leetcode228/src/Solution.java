import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length, l = 0;
        ArrayList<String> res = new ArrayList<>();
        if (n == 0) return res;
        for (int r = 0; ; r++) {
            //添加的条件：r与前一项不连续
            if (r == n || (r > 0 && nums[r] - 1 != nums[r-1])) {
                if (l == r-1) res.add(String.valueOf(nums[l]));
                else res.add(nums[l] + "->" + nums[r - 1]);
                l = r;
                if (r == n) break;
            }
        }
        return res;
    }
}