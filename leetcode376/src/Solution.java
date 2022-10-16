class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n - 1];
        //diff[i]表示nums[i + 1]与nums[i]之差
        for (int i = 1; i < n; i++) {
            diff[i - 1] = nums[i] - nums[i - 1];
        }
        //对于diff[i]，相邻元素必须异号，如果存在单调区间，则取单调区间的最值（即序号最靠后的元素）
        int res = 1,cur = 0;
        for (int i = 1; i < diff.length; i++) {
            if (diff[i] * diff[cur] < 0) {
                if (res == 1) res += 2;
                else res++;
            }
            //不能让cur更新到diff[i]取到0的情况，否则下一次一定会漏解
            if (diff[i] != 0) cur = i;
        }
        //res = 1的充要条件是nums中所有元素都相等，即diff[i]恒等于0
        if (res == 1) {
            for (int value : diff) {
                if (value != 0) {
                    res = 2;
                    break;
                }
            }
        }
        return res;
    }
}

class Solution2 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) up = down + 1;
            else if (nums[i] < nums[i-1]) down = up + 1;
        }
        return Math.max(up, down);
    }
}