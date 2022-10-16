import java.util.Arrays;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums1.length; i++) {
            boolean isValid = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) isValid = true;
                if (isValid && nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {4,1,2};
        int[] nums2 = new int[] {1,3,4,2};
        int[] res = new Solution().nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(res));
    }
}
