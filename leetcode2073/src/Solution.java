class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;
        for (int i = 0; i < tickets.length; i++) {
            //people in front of k buy at most k tickets
            if (i <= k) res += Math.min(tickets[i],tickets[k]);
            //people behind k buy at most k-1 tickets
            else res += Math.min(tickets[i],tickets[k]-1);
        }
        return res;
    }
}