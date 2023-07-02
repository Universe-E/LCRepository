import java.util.TreeMap;

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        var map = new TreeMap<Integer,Integer>();
        long res = 0;
        for (int i = 0,j = 0; i < n;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while (!map.isEmpty() && map.lastKey()-map.firstKey() > 2) {
                map.put(nums[j],map.get(nums[j])-1);
                if (map.get(nums[j]) == 0) map.remove(nums[j]);
                j++;
            }
            res += i-j+1;
        }
        return res;
    }
}