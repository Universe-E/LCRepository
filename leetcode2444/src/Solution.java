import java.util.TreeMap;

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        long res = (long) n*(n+1)/2;
        for (int r = 0,l = 0; r < n; r++) {
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while (l < r && map.firstKey() == minK && map.lastKey() == maxK) {
                map.put(nums[l],map.get(nums[l])-1);
                if (map.get(nums[l]) == 0) map.remove(nums[l]);
            }
            if (!(map.firstKey() == minK && map.lastKey() == maxK)) {
                res -= r-l+1;
            }
        }
        return res;
    }
}