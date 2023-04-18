import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 1;
        for (int num : nums) {
            if (set.contains(num)) {
                int l = num - 1, r = num + 1, cnt = 1;
                while (set.contains(l)) {
                    set.remove(l);
                    l--;
                    cnt++;
                }
                while (set.contains(r)) {
                    set.remove(r);
                    r++;
                    cnt++;
                }
                max = Math.max(max,cnt);
            }
        }
        return max;
    }
}