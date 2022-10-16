import java.util.HashMap;

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int value = map.get(num) + 1;
                map.put(num, value);
            } else map.put(num, 1);
        }
        for (Integer i : map.keySet()) if (map.get(i) != 2) return i;
        return - 1;
    }
}
