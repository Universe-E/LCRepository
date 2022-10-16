class Solution {
    public int findMagicIndex(int[] nums) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) return i;
        }
        return res;
    }
}
