class Solution {
    int n;
    long res;
    int[] nums;
    public long maxStrength(int[] nums) {
        n = nums.length;
        this.nums = nums;
        res = Long.MIN_VALUE;
        backTrack(0,0,1);
        return res;
    }

    private void backTrack(int i,int n2,long cur) {
        //不能一个人都不选
        if (i == n) {
            if (n2 != 0) res = Math.max(res,cur);
            return;
        }
        //选i
        backTrack(i+1,n2+1,cur*nums[i]);
        //不选i
        backTrack(i+1,n2,cur);
    }
}