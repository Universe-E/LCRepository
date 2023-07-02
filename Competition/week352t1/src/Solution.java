class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int res = 0;
        for (int l = 0; l < n; l++) {
            if (nums[l]%2 != 0) continue;
            for (int r = l; r < n; r++) {
                boolean v = true;
                for (int i = l; i <= r; i++) {
                    if (nums[i] > threshold) {
                        v = false;
                        break;
                    }
                    if (i != r) {
                        if (nums[i]%2 == nums[i+1]%2) {
                            v = false;
                            break;
                        }
                    }
                }
                if (v) res = Math.max(res,r-l+1);
            }
        }
        return res;
    }
}