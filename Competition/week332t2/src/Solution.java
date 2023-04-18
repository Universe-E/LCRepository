import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(o->nums[o]));
        long res = 0;
        for (int i = 0; i < n; i++) {
            //每次找小于lt的最大值所在索引，和大于ut的最小值所在索引
            int lt = lower-nums[idx[i]], ut = upper-nums[idx[i]];
            int l1 = 0,r1 = n-1,l2 = 0,r2 = n-1;
            if (nums[idx[0]] >= lt) l1 = -1;
            else {
                while (l1 < r1) {
                    int m = l1+(r1-l1+1)/2;
                    if (nums[idx[m]] >= lt) r1 = m-1;
                    else l1 = m;
                }
            }
            if (nums[idx[n-1]] <= ut) l2 = n;
            else {
                while (l2 < r2) {
                    int m = l2+(r2-l2)/2;
                    if (nums[idx[m]] <= ut) l2 = m+1;
                    else r2 = m;
                }
            }
            //两处边界分别为l2和l1，注意减去自己
            res += l2-l1-((i>l1&&i<l2)?2:1);
        }
        return res/2;
    }
}