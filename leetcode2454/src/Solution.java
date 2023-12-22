import java.util.*;

class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (o1,o2) -> (nums[o2]-nums[o1]));
        int[] res = new int[n];
        Arrays.fill(res,-1);
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int id = idx[i];
            Integer first = set.higher(id), second = first == null ? null : set.higher(first);
            //there are 2 indexs that bigger than id
            if (first != null && second != null) {
                res[id] = nums[second];
            }
            set.add(id);
        }
        return res;
    }
}