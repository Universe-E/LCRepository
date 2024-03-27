import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static final int M = (int) 1e9+7;
    public int countWays(int[][] ranges) {
        int p = 0,preLast = -1;
        Arrays.sort(ranges, Comparator.comparingInt(o->o[0]));
        for (int[] r : ranges) {
            //merge
            if (r[0] > preLast) p++;
            preLast = Math.max(preLast,r[1]);
        }
        return fp(2,p);
    }

    private int fp(int b,int p) {
        if (p == 0) return 1;
        if (p == 1) return b;
        int b2 = fp(b,p/2);
        if (p%2 == 0) return (int) ((long)b2*b2%M);
        else return (int) ((long)b2*b2%M*b%M);
    }
}