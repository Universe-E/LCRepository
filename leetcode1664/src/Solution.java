class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        if (n == 2) return 0;
        //record prefix and suffix
        int[] pre = new int[n],suf = new int[n];
        pre[0] = nums[0];
        pre[1] = nums[1];
        suf[n-1] = nums[n-1];
        suf[n-2] = nums[n-2];
        for (int i = 2; i < n; i++) {
            pre[i] = pre[i-2] + nums[i];
            suf[n-i-1] = nums[n-i-1] + suf[n-i+1];
        }
        int res = 0;
        //for each i, compare pre[i-2]+suf[i+1] and pre[i-1]+suf[i+2]
        for (int i = 0; i < n; i++) {
            int pre1 = ((i-2)>=0 ? pre[i-2] : 0) + ((i+1)<n ? suf[i+1] : 0);
            int pre2 = ((i-1)>=0 ? pre[i-1] : 0) + ((i+2)<n ? suf[i+2] : 0);
            if (pre1 == pre2) res++;
        }
        return res;
    }
}