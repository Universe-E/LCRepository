import java.util.Arrays;

class Solution {
    private static final int M = (int) 1e9+7;
    int res = 0,n;
    public int specialPerm(int[] nums) {
        n = nums.length;
        boolean[] v = new boolean[n];
        Arrays.sort(nums);
        bt(0,nums,new boolean[n]);
        return res;
    }

    private void bt(int i,int[] nums,boolean[] v) {
        if (i == n) {
            res = (res+1)%M;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (v[j]) continue;
            if (nums[j]%nums[i] == 0) {
                v[j] = true;
                bt(j+1,nums,v);
                v[j] = false;
            }
        }
    }
}