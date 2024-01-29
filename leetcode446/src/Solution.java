import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        HashMap<Long,Integer>[] maps = new HashMap[n];
        Arrays.setAll(maps,e->new HashMap<>());
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                long diff = (long) nums[i]-nums[j];
                int count = 0;
                if (maps[j].containsKey(diff)) count = maps[j].get(diff);
                res += count;
                count++;
                maps[i].put(diff,maps[i].getOrDefault(diff,0)+count);
            }
        }
        return res;
    }
}