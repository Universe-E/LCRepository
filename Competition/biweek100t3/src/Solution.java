import java.util.Comparator;
import java.util.TreeSet;

class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        long res = 0;
        TreeSet<Integer> set = new TreeSet<>((p, q) -> {
            if (nums[p] == nums[q]) return p-q;
            return nums[p]-nums[q];
        });
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        while (!set.isEmpty()) {
            int ptr = set.pollFirst();
            if (ptr > 0) set.remove(ptr-1);
            if (ptr < n-1) set.remove(ptr+1);
            res += nums[ptr];
        }
        return res;
    }
}