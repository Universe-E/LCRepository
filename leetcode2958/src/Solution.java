import java.util.HashMap;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length,l = 0,res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int r = 0; r < n; r++) {
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while (l < r && map.get(nums[r]) > k) {
                map.put(nums[l],map.get(nums[l])-1);
                if (map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}