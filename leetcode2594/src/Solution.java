import java.util.Arrays;

class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        //设最短和最长时间
        long l = 1,r = (long) ranks[0]*cars*cars;
        while (l < r) {
            long m = (l+r)/2;
            if (ok(ranks,m,cars)) r = m;
            else l = m+1;
        }
        return l;
    }

    //在给定m的时间内，所有工人能否把cars全部修完
    private boolean ok(int[] ranks, long m, int cars) {
        int cnt = 0;
        for (int r : ranks) {
            cnt += Math.floor(Math.sqrt((double) m/r));
        }
        return cnt >= cars;
    }
}