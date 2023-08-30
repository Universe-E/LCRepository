class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long cnt = 0;
        int mx = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            //如果nums[i] <= mx，相除得0，可以省略判断
//            if (nums[i] <= mx) {
//                mx = nums[i];
//                continue;
//            }
            int d = (nums[i]-1)/mx;
            cnt += d;
            //多除一个，可以保证留给后面的最小值最大，例如[...,10,4]，分成[...,3,3,4,4]，而不是[...,2,4,4,4]
            mx = nums[i]/(d+1);
        }
        return cnt;
    }
}