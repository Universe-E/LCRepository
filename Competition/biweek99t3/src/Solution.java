import java.util.Arrays;

class Solution {
    public static final int M = (int)1e9 + 7;
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges,(o1,o2) -> (o1[0]==o2[0] ? (o2[1]-o1[1]) : (o1[0]-o2[0])));
        int cnt = 0, rb = -1;
        for (int[] range : ranges) {
            int l = range[0], r = range[1];
            //如果找到了比当前rb更大的左边界，说明是新的一组
            if (l > rb) cnt++;
            rb = Math.max(rb, r);
        }
        //快速幂
        return fp(cnt);
    }

    private int fp(int cnt) {
        if (cnt == 1) return 2;
        long temp = fp(cnt/2);
        if (cnt%2==1) return (int)(temp*temp*2%M);
        else return (int)(temp*temp%M);
    }

}