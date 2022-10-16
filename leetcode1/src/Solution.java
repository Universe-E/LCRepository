import java.util.TreeMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                a = i;
                b = map.get(target - nums[i]);
                if (a != b) break;
            }
        }
        return new int[] {a,b};
    }
}
