import java.util.Arrays;

class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = (n+1)/2, r = n-1;
        while (l < r) {
            int m = (l+r)/2;
            if (check(m,nums)) r = m;
            else l = m+1;
        }
        if (l == n-1 && nums[n-1] < 2*nums[0]) return 0;
        return (n-l)*2;
    }
    private boolean check(int m,int[] nums) {
        for (int i = m; i < nums.length; i++) {
            if (nums[i] < 2*nums[i-m]) return false;
        }
        return true;
    }
}

class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length,res = 0;
        int l = 0,r = (n+1)/2;
        while (r < n) {
            if (nums[r] >= 2*nums[l]) {
                l++;
                r++;
                res += 2;
            }
            else r++;
        }
        return res;
    }
}