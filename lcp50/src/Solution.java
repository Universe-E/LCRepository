class Solution {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] o : operations) {
            int x = o[0],y = o[1];
            int transfer = gem[x]/2;
            gem[x] -= transfer;
            gem[y] += transfer;
        }
        int mx = -1,mn = 0x3f3f3f3f;
        for (int i : gem) {
            mx = Math.max(mx,i);
            mn = Math.min(mn,i);
        }
        return mx-mn;
    }
}