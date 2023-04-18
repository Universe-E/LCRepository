class Solution {
    public long repairCars(int[] ranks, int cars) {
        long l = 0,r = (long)1e14;
        while (l < r) {
            //最多给m分钟
            long m = (l+r)/2;
            int cnt = 0;
            //m分钟内能修多少辆车
            for (int rank : ranks) {
                cnt += Math.sqrt(m / rank);
            }
            if (cnt < cars) l = m+1;
            else r = m;
        }
        return l;
    }
}