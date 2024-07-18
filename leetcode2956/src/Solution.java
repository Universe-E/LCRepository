class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] cnt1 = new int[101], cnt2 = new int[101];
        for (int i : nums1) {
            cnt1[i]++;
        }
        for (int i : nums2) {
            cnt2[i]++;
        }
        int[] res = new int[2];
        for (int i = 0; i < 101; i++) {
            if (cnt1[i] != 0 && cnt2[i] != 0) {
                res[0] += cnt1[i];
                res[1] += cnt2[i];
            }
        }
        return res;
    }
}