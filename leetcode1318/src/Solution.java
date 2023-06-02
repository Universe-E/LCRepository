class Solution {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int ai = (a>>(31-i))&1,bi = (b>>(31-i))&1, ci = (c>>(31-i))&1;
            if ((ai|bi) != ci) {
                if (ci == 0) res += (ai==1 ? 1 : 0) + (bi==1 ? 1 : 0);
                if (ci == 1) res += 1;
            }
        }
        return res;
    }
}