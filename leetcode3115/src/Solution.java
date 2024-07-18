import java.util.Arrays;

class Solution {
    public int maximumPrimeDifference(int[] nums) {
        boolean[] p = new boolean[101];
        Arrays.fill(p,true);
        p[0] = false;
        p[1] = false;
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j * i <= 100; j++) {
                p[j * i] = false;
            }
        }
        int n = nums.length, l = -1, r = -1;
        for (int i = 0; i < n; i++) {
            if (p[nums[i]]) {
                if (l == -1) l = i;
                if (i > r) r = i;
            }
        }
        return r-l;
    }
}