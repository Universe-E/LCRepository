import java.util.TreeMap;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length, res = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int r = 0, l = 0; r < n; r++) {
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while (l < r && map.lastKey() - map.firstKey() > limit) {
                map.put(nums[l],map.get(nums[l])-1);
                if (map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}