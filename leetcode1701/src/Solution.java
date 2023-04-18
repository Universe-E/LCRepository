class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        long start = customers[0][0];
        long wait = 0;
        for (int[] customer : customers) {
            start = Math.max(start,customer[0]);
            start += customer[1];
            wait += start - customer[0];
        }
        return (double) wait / n;
    }
}