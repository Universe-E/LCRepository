import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i],i);
        }
        for (int[] op : operations) {
            if (map.containsKey(op[0])) {
                int idx = map.get(op[0]);
                nums[idx] = op[1];
                map.put(op[1],idx);
            }
        }
        return nums;
    }
}