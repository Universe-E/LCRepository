import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
        for (int i : nums1) {
            s1.add(i);
        }
        for (int i : nums2) {
            s2.add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> l1 = new HashSet<>(), l2 = new HashSet<>();
        for (int num : nums1) {
            if (!s2.contains(num)) l1.add(num);
        }
        for (int num : nums2) {
            if (!s1.contains(num)) l2.add(num);
        }
        res.add(new ArrayList<>(l1));
        res.add(new ArrayList<>(l2));
        return res;
    }
}