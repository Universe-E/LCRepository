class Solution {
    public int alternatingSubarray(int[] nums) {
        int n = nums.length,res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (ok(i,j,nums)) res = Math.max(res,j-i+1);
            }
        }
        return res == 0 ? -1 : res;
    }

    private boolean ok(int i,int j,int[] nums) {
        for (int k = i+1; k <= j; k++) {
            if (nums[k]-nums[k-1] != (int) Math.pow(-1,(k-i-1)%2)) return false;
        }
        return true;
    }
}