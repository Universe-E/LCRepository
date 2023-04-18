class Solution {
    public int minCapability(int[] nums, int k) {
        int l = 0, r = 0x3f3f3f3f;
        //二分查找
        while (l < r) {
            int m = l + (r-l)/2;
            //如果当前窃取能力m满足题意，则让右边界缩到这里
            if (check(nums,k,m)) r = m;
            //否则左边界需要扩张
            else l = m+1;
        }
        return l;
    }

    //排除错误思路，不要总想着只偷k间房屋
    private boolean check(int[] nums,int k,int m) {
        int cnt = 0;
        for (int i = 0;i < nums.length;) {
            //如果nums[i]未达到目标窃取能力，则i跳到下下位
            if (nums[i] <= m) {
                cnt++;
                i += 2;
            }
            else i++;
        }
        return cnt >= k;
    }
}