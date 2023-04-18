import java.util.TreeSet;

class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        TreeSet<Integer> s1 = new TreeSet<>(),s2 = new TreeSet<>();
        for (int num : nums1) {
            s1.add(num);
        }
        for (int num : nums2) {
           s2.add(num);
        }
        for (Integer i : s2) {
            if (s1.contains(i)) return i;
        }
        int n1 = s1.first(),n2 = s2.first();
        if (n1 > n2) return n2*10+n1;
        return n1*10+n2;

    }
}