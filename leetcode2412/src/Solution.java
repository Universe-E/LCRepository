class Solution {
    public long minimumMoney(int[][] transactions) {
        long res = 0;
        int maxCashback = 0,maxStart = 0;
        //1、先赔钱再赚钱，这样才能让启动资金最大化
        //2、对于所有不赚钱的交易，亏掉的钱是恒定多的,整个过程中要让找回的钱最少，
        //即要让找钱最多的一个排在最后，设为maxCashback
        //3、然后再开始赚钱的交易
        //4、对于所有赚钱的交易，整个过程要让启动资金最大，
        //即从赚钱的交易开始至少要准备max(cost)，设为maxStart
        //5、因此在拐点时，剩余的钱数应为max(maxCashback,maxStart)
        for (int[] t : transactions) {
            //不赚钱的交易
            if (t[0] >= t[1]) {
                res += t[0]-t[1];
                maxCashback = Math.max(maxCashback,t[1]);
            }
            //赚钱的交易
            else maxStart = Math.max(maxStart,t[0]);
        }
        res += Math.max(maxStart,maxCashback);
        return res;
    }
}