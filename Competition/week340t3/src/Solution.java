import java.util.Arrays;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = nums[n-1];
        while (l < r) {
            int m = l + (r-l)/2;
            if (check(nums,m,p)) r = m;
            else l = m+1;//m设得太小
        }
        return l;
    }


    //以t为最大差值基准，考察差值<=t的个数cnt，若cnt>=p则成立
    private boolean check(int[] nums,int t,int p) {
        int pre = nums[0], cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            //将pre置为-1避免差值相邻
            if (pre != -1 && cur - pre <= t) {
                cnt++;
                pre = -1;
            }
            else pre = cur;
        }
        return cnt >= p;
    }
}