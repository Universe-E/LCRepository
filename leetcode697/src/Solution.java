import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list;
            if (!map.containsKey(nums[i])) {
                list = new ArrayList<>();
            }
            else {
                list = map.get(nums[i]);
            }
            list.add(i);
            map.put(nums[i], list);
        }
        int max = 0,res = 50001;
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            int size = list.size();
            System.out.println(size);
            if (size >= max) {
                if (size == max) res = Math.min(res,list.get(size - 1) - list.get(0) + 1);
                else res = list.get(size - 1) - list.get(0) + 1;
                max = size;
            }
        }
        return res;
    }
}