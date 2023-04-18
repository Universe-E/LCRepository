class Solution {
    public int maxValue(int n, int index, int maxSum) {
        //相当于寻找数组中“隆起的山峰”，计算总高度差即可
        int l = 0, r = (int)(1e9);
        while (l < r) {
            //lH和rH分别代表等差数列的左右边界（即“首项”）
            int mid = (l + r + 1) / 2,lH,rH;
            //lA和rA分别代表左右两侧，公差为1的等差数列和
            long lA,rA;
            //左侧等差数列求和
            if (mid > index) {
                lH = mid - index;
                lA = (long) (index+1)*(lH+mid)/2;
            }
            else {
                lA = (long) mid*(1+mid)/2;
            }
            //右侧等差数列求和
            if (mid > n - index - 1) {
                rH = mid - n + index + 1;
                rA = (long) (n-index)*(mid+rH)/2;
            }
            else {
                rA = (long) mid*(1+mid)/2;
            }
            //求总和，左侧+右侧-index处的“高度差”
            long A = lA + rA - mid;
            if (A > maxSum - n) r = mid - 1;
            else l = mid;
        }
        //l的意义为“高度差”，因此返回结果应当加1
        return l+1;
    }
}