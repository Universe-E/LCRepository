class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int remain = 0,cur = 0,cnt = 0, max = 0,res = 0;
        do {
            if (cnt < customers.length) remain += customers[cnt];
            int member = Math.min(4,remain);
            cur += member*boardingCost-runningCost;
            remain -= member;
            if (cur > max) {
                max = cur;
                res = cnt;
            }
            cnt++;
        } while (remain > 0 || cnt < customers.length);
        return max<=0 ? -1 : (res+1);
    }
}