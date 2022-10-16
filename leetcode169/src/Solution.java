import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) > nums.length / 2) return integer;
        }
        return -1;
    }
}
