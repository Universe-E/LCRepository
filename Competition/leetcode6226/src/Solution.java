import java.util.*;

class Solution {
    public int destroyTargets(int[] nums, int space) {
        int n = nums.length;
        //nums[i] mod space to find the remainder
        int[] rs = new int[n];
        for (int i = 0; i < n; i++) {
            rs[i] = nums[i] % space;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list;
            if (!map.containsKey(rs[i])) list = new ArrayList<>();
            else list = map.get(rs[i]);
            //list stores indexes that have the same remainder
            list.add(i);
            map.put(rs[i], list);
        }
        int res = Integer.MAX_VALUE,size = 0;
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() > size) {
                size = list.size();
                //sorted by nums[i]
                list.sort(Comparator.comparingInt(o -> nums[o]));
                res = nums[list.get(0)];
            }
            if (list.size() == size) {
                list.sort(Comparator.comparingInt(o -> nums[o]));
                res = Math.min(res,nums[list.get(0)]);
            }
        }
        return res;
    }
}