class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int prev1 = 1,prev2 = 2;
        //当前阶可以从(n - 1)一步上来，也可以从(n - 2)一步或两步上来
        //n >= 4时进入循环
        for (int i = 3; i < n; i++) {
            int temp = prev1;//先暂存prev1
            //接下来上楼梯，令(n - 3)的阶数等于(n - 2)的阶数，(n - 2)的阶数等于(n - 1)的阶数
            prev1 = prev2;
            prev2 = temp + prev2;
        }
        //最后返回(n - 2)的阶数+(n - 1)的阶数即可
        return prev1 + prev2;
    }
}
