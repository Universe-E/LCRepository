import java.util.HashSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] cnt = new int[1001];
        for (int num : nums1) {
            cnt[num]++;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums2) {
            if (cnt[num] != 0) {
                set.add(num);
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            res[i] = num;
            i++;
        }
        return res;
    }
}