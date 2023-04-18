class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max = 0;
        for (int num : nums) max = Math.max(max,num);
        boolean[] vis = new boolean[max+1];
        for (int num : nums) vis[num] = true;
        int res = 0;
        for (int i = 1; i <= max; i++) {
            int g = 0;//0和任何数x的最大公约数都是x
            //寻找i的倍数，如果num中存在j=c*i(c为常数)，则更新g
            for (int j = i; j <= max; j+=i) {
                if (vis[j]) {
                    g = gcd(j,g);
                }
                //如果找到了当前i能作为最大公约数，则记录答案
                if (g == i) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    private int gcd(int j, int g) {
        return g == 0 ? j : gcd(g,j%g);
    }
}