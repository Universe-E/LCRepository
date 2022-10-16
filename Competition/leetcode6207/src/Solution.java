import java.util.ArrayList;
import java.util.List;

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        //用p表示不在[minK,maxK]区间的分隔点，要求minK和maxK都要出现在p右侧才行
        int minp = -1,maxp = -1,p = -1;
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == minK) minp = i;
            if (nums[i] == maxK) maxp = i;
            if (nums[i] < minK || nums[i] > maxK) p = i;
            //只要还没到下一个p，且在这个区间内minp和maxp都被更新过，就可以用Math.min(minp,maxp)与最左侧分隔点相减
            //即使相等也合理，例如[1,1,1,1]，所有的minp和maxp都相等，且p始终是-1
            if (Math.min(minp,maxp) > p) res += Math.min(minp,maxp) - p;
        }
        return res;
    }
}