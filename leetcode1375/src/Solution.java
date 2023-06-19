class Solution {
    public int numTimesAllBlue(int[] flips) {
        int res = 0;
        for (int i = 0,mx = flips[0]; i < flips.length; i++) {
            mx = Math.max(mx,flips[i]);
            if (mx == i+1) res++;
        }
        return res;
    }
}