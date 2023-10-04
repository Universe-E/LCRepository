import java.util.Arrays;

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx,(o1,o2) -> (growTime[o2]-growTime[o1]));
        int grow = 0,plan = 0;
        for (int i = 0; i < n; i++) {
            plan += plantTime[idx[i]];
            //因为plantTime是必须要的时间，而growTime并不一定，
            //某个花growTime特别大，那么先种它，在它growTime的时间你可以种其他的是最好的方案，
            //如果其他花growTime+plantTime都比这个growTime短那么就是上面假设的情况，如果不是更新这个最大growTime结束的期限
            if (grow < plan + growTime[idx[i]]) grow = plan + growTime[idx[i]];
        }
        return grow;
    }
}