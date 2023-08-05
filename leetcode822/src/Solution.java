import java.util.HashSet;

class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        var set = new HashSet<Integer>();
        int n = fronts.length;
        //result must not be those both sides are the same
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) set.add(fronts[i]);
        }
        int res = 2001;
        for (int front : fronts) {
            if (!set.contains(front)) res = Math.min(res,front);
        }
        for (int back : backs) {
            if (!set.contains(back)) res = Math.min(res,back);
        }
        return res == 2001 ? 0 : res;
    }
}