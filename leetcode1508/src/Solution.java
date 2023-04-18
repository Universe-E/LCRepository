class Solution {
    /*二分查找 + 前缀和的前缀和 + 双指针
            1.核心思路：本题所求结果可以转换为，求所有子数组的和中前right个最小的之和 - 前left-1个最小的之和
                注意：一看到前i个子数组和的和值就能想到本题可以使用"前缀和的前缀和"，但是具体应该怎么进行呢？
            2.思考过程：
                1）首先我们要设计一个函数，这个函数能够计算出所有子数组的和中前i个最小的和值，
                然后我们把right和left-1分别带入进去，结果就能算的出来了
                2）我们要求出前i个最小的 子数组和 的和值，首先我们要求出第i小的子数组和
                    求第i小的子数组和的过程是使用了双指针和二分查找，具体过程见代码及注释
                3）我们求出第i小的子数组和sumi之后，我们就能求出所有"严格小于"sumi的子数组和的总和以及数量cnt，
                cnt一定是不足i个的，我们不足的就用sumi去补足
                【因为等于sumi的子数组和可能有很多个，我们并不知道应该取多少个，所以要把比sumi小的先取上，然后不够的sumi来补】
        */
    int n;
    long[] p;
    long[] pp;
    public static final int M = (int)1e9+7;
    public int rangeSum(int[] nums, int n, int left, int right) {
        //p表示数组nums的前缀和，pp表示p的前缀和，即nums前缀和的前缀和
        this.n = n;
        p = new long[n+1];
        pp = new long[n+2];
        for (int i = 1; i < n+1; i++) {
            p[i] = p[i-1] + nums[i-1];
        }
        for (int i = 2; i < n+2; i++) {
            pp[i] = pp[i-1] + p[i-1];
        }
        return (getSum(right) - getSum(left-1))%M;

    }

    //求前k小个前缀和的和值
    private int getSum(int k) {
        //获取第k小的子数组和sumk
        long sumk = getsumk(k);
        //求出所有严格小于sumk的子数组和的总和，以及总量cnt
        long sum = 0, cnt = 0;
        //按照滑动窗口的思路，枚举子数组和的开始索引，不断扩大右边界j直到p[j]-p[i] >= sumk
        //然后j不动，左边界i前移
        for (int i = 0, j = 1; i < n; i++) {
            //每一次，j扩增到第一个不符合条件的右边界
            while (j <= n && p[j] - p[i] < sumk) j++;
            //为保证右边界j索引不越界，j回退回来，到达最后一个符合条件的右边界
            j--;
            //前缀和的前缀和的用途：
            //我们这里要求的子数组和就是p[i+1]-p[i],p[i+2]-p[i],...,p[j]-p[i]，我们要求的是这些数的和值
            //因此每一次sum自增的量△sum = p[i+1] + p[i+2] + ...p[j] - (j-i)*p[i] = pp[j+1] - pp[i+1] - (j-i)*p[i]
            sum = (sum + pp[j+1] - pp[i+1] - (j-i)*p[i]%M + M)%M;
            //每次计入cnt的量
            cnt += j-i;
        }
        return (int) (sum + (k-cnt)*sumk%M + M)%M;
    }

    //用二分查找求第k小的子数组和
    //这里主要采用的思路就是二分查找，因为前缀和这个数组一定是递增的，所以最小值是0，最大值是p[n]
    //我们就采用二分查找的方法在[0,p[n]]范围内枚举，寻找一个值是否是第k小的子数组和
    //对于一个数值num来说，我们可以寻找小于等于num的子数组和有多少个，然后根据这个数量cnt来判断二分查找的边界应该怎么移动
    private long getsumk(int k) {
        long l = 0, r = p[n];
        while (l < r) {
            long m = (l + r)/2;
            int cnt = getCnt(n,m);
            //说明l太小，还需增大才行
            if (cnt < k) l = m+1;
            else r = m;
        }
        return l;
    }

    //按照滑动窗口的思路，寻找值为t时前面元素的个数
    private int getCnt(int n, long t) {
        int cnt = 0;
        for (int r = 1,l = 0; r <= n; r++) {
            //由于p数组递增，找到第一个能让p[r]-p[l]<=t的l
            while (l < r && p[r]-p[l] > t) l++;
            //对于r所在的每轮循环，每次位于[l,r]区间的子数组都符合条件
            cnt += r-l;
        }
        return cnt;
    }
}