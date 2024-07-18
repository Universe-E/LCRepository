class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int empty = 0, cnt = 0;
        while (numBottles != 0) {
            //drink
            cnt += numBottles;
            empty += numBottles;
            numBottles = 0;

            //exchange
            if (empty >= numExchange) {
                int exBottles = empty / numExchange;
                numBottles += exBottles;
                empty -= exBottles * numExchange;
            }
        }
        return cnt;
    }
}