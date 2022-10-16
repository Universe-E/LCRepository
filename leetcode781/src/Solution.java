import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : answers) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int res = 0;
        for (Integer key : map.keySet()) {
            int val = map.get(key);
            if (val % (key + 1) == 0) res += val;
            else {
                int diff = val / (key + 1);
                res += (key + 1) * (diff + 1);
            }
        }
        return res;
    }
}