import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class Solution {
    private HashMap<Integer, List<Integer>> map;
    private Random random = new Random();
    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list;
            if (!map.containsKey(nums[i])) list = new ArrayList<>();
            else list = map.get(nums[i]);
            list.add(i);
            map.put(nums[i], list);
        }
    }
    public int pick(int target) {
        List<Integer> list = map.get(target);
        int p = random.nextInt(list.size());
        return list.get(p);
    }
}
