import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] cnt = new int[105];
        boolean[] added = new boolean[105];
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            if (!added[num]) {
                cnt[num]++;
                added[num] = true;
            }
        }
        Arrays.fill(added,false);
        for (int num : nums2) {
            if (!added[num]) {
                cnt[num]++;
                added[num] = true;
            }
        }
        Arrays.fill(added,false);
        for (int num : nums3) {
            if (!added[num]) {
                cnt[num]++;
                added[num] = true;
            }
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] >= 2) list.add(i);
        }
        return list;
    }
}