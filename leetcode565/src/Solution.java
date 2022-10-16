import java.util.*;

class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        TreeSet<Integer> set = new TreeSet<>(Comparator.comparingInt(o -> o));
        for (int i = 0; i < nums.length; i++) set.add(i);
        while (set.size() > 0) {
            int i = set.first();
            Set<Integer> cur = new TreeSet<>();
            while (!cur.contains(nums[i])) {
                cur.add(nums[i]);
                set.remove(i);
                i = nums[i];
            }
            res = Math.max(res,cur.size());
        }
        return res;
    }
}

class Solution2 {
    public int arrayNesting(int[] nums) {
        int res = 0, n = nums.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            int cur = 0;
            while (!vis[i]) {
                cur++;
                vis[i] = true;
                i = nums[i];
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}