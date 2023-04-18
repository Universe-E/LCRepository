import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        HashMap<Integer,Integer> pre = new HashMap<>();
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int m = (int)(sum%p);
        if (m == 0) return 0;
        int n = nums.length, res = n,cur = 0;
        pre.put(0,0);
        for (int i = 0; i < n; i++) {
            cur = (cur + nums[i])%p;
            pre.put(cur,i+1);
            //目标区间和与p取模要等于m
            int cur2 = (cur-m+p)%p;
            if (pre.containsKey(cur2)) res = Math.min(res,i+1-pre.get(cur2));
        }
        return res==n ? -1 : res;
    }
}