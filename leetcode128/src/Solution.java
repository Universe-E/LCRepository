import java.util.HashMap;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            int l = 0, r = 0;
            if (!map.containsKey(num)) {
                if (map.containsKey(num - 1)) l = map.get(num - 1);
                if (map.containsKey(num + 1)) r = map.get(num + 1);
                //当前要连接的值
                int cur = l + r + 1;
                map.put(num,cur);
                //注意，区间中间的值可以不管，但要更新两端的值
                map.put(num - l,cur);
                map.put(num + r,cur);
                res = Math.max(res,cur);
            }
        }
        return res;
    }
}