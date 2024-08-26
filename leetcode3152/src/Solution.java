import java.util.HashSet;
import java.util.TreeSet;

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i < nums.length; i++) {
            //取不满足条件的右端点索引，也可以取左端点索引
            if (nums[i]%2 + nums[i-1]%2 != 1) set.add(i);
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            //由于取的是右端点，因此l = from+1, r = to
            //如果取左端点，就是l = from, r = to-1
            int l = queries[i][0]+1, r = queries[i][1];
            Integer high = set.ceiling(l), low = set.floor(r);
            //[l,r]区间内不能有不满足条件的值
            res[i] = (high == null || high > r) && (low == null || low < l);
        }
        return res;
    }
}