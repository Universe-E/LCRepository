import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        List<Long> res = new ArrayList<>();
        Arrays.sort(nums);
        long[] pre = new long[n+1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i-1] + nums[i-1];
        }
        //每次二分查找queries[i]左右各有几个元素
        for (int q : queries) {
            int high = bs_high(nums,q), low = bs_low(nums,q);
            //大于q的有n-low-1个元素,小于q的有high个元素
            long bigger = pre[n]-pre[low+1] - (long)(n-low-1)*q;
            long smaller = (long)high*q - (pre[high]-pre[0]);
            res.add(bigger+smaller);
        }
        return res;
    }

    //找>=t的最小i
    private int bs_high(int[] nums,int t) {
        int n = nums.length;
        if (t > nums[n-1]) return n;
        int l = 0, r = n-1;
        while (l < r) {
            int m = (l+r) / 2;
            if (nums[m] < t) l = m+1;
            else r = m;
        }
        return l;
    }

    //找<=t的最大i
    private int bs_low(int[] nums, int t) {
        int n = nums.length;
        if (t < nums[0]) return -1;
        int l = 0, r = n-1;
        while (l < r) {
            int m = (l+r+1) / 2;
            if (nums[m] > t) r = m-1;
            else l = m;
        }
        return l;
    }
}