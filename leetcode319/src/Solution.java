class Solution {
    //第i个灯的翻转次数等于其所有因子的个数（包括1和i）
    //只有平方数的因子个数不是成对出现，举例：4=1*4,2*2，其因子是1,2,4
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}