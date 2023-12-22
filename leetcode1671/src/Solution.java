import java.util.Arrays;

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] inc = new int[n],dec = new int[n];
        Arrays.fill(inc,1);
        Arrays.fill(dec,1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) inc[i] = Math.max(inc[i],inc[j]+1);
            }
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = n-1; j > i; j--) {
                if (nums[i] > nums[j]) dec[i] = Math.max(dec[i],dec[j]+1);
            }
        }
        int res = n;
        for (int i = 0; i < n; i++) {
            if (inc[i] == 1 || dec[i] == 1) continue;
            res = Math.min(res,n-inc[i]-dec[i]+1);
        }
        System.out.println(Arrays.toString(inc));
        System.out.println(Arrays.toString(dec));
        return res;
    }
}