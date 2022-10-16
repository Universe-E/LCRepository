import java.util.HashMap;

class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num,1);
            else map.put(num, map.get(num) + 1);
        }
        int i = 0;
        int l0 = map.getOrDefault(0, 0);
        int l1 = map.getOrDefault(1,0);
        while (i < nums.length) {
            if (i < l0) nums[i] = 0;
            else if (i < l0 + l1) nums[i] = 1;
            else nums[i] = 2;
            i++;
        }
    }
}
