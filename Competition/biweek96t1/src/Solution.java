import java.util.TreeSet;

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        TreeSet<Integer> s1 = new TreeSet<>();
        for (int i : nums1) {
            s1.add(i);
        }
        int res = 0x3f3f3f3f;
        for (int i : nums2) {
            if (s1.contains(i)) res = Math.min(res,i);
        }
        return res == 0x3f3f3f3f ? -1 : res;
    }
}