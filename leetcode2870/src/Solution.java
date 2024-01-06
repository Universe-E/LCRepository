import java.util.HashMap;

class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        if (map.containsValue(1)) return -1;
        int res = 0;
        for (Integer k : map.keySet()) {
            res +=cal(map.get(k));
        }
        return res;
    }

    private int cal(Integer v) {
        return v/3 + (v%3 == 0 ? 0 : 1);
    }

}