import java.util.HashMap;

class Solution {
    public int unequalTriplets(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int res = 0, n = nums.length, past = 0;
        for (Integer key : map.keySet()) {
            int v = map.get(key);
            res += past*v*(n-past-v);
            past += v;
        }
        return res;
    }
}