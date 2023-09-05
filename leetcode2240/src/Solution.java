class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        int mx = Math.max(cost1,cost2),mn = Math.min(cost1,cost2);
        while (total >= 0) {
            res += total/mn + 1;
            total -= mx;
        }
        return res;
    }
}