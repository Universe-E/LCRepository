class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        //从终点向起点遍历，只能向左或向上移动，得出每个点最少的血量
        int[][] minHealth = new int[m][n];
        //对于P点:
        //如果dungeon[m - 1][n - 1]的值非负，则该点血量为1，否则该点血量为1 + 扣掉的血量
        minHealth[m - 1][n - 1] = Math.max(1,1 - dungeon[m - 1][n - 1]);
        //对于最后一列和最后一行:
        //只能向上或向左遍历，该点最少血量为(后一个点最少血量 - 当前点的值)，但不小于1
        for (int i = m - 2; i >= 0; i--)
            minHealth[i][n - 1] = Math.max(1,minHealth[i + 1][n - 1] - dungeon[i][n - 1]);
        for (int i = n - 2; i >= 0; i--)
            minHealth[m - 1][i] = Math.max(1,minHealth[m - 1][i + 1] - dungeon[m - 1][i]);
        //对于其他行列:
        //该点最小血量为[min(右方最小血量，下方最小血量) - 当前点的值]，但不小于1
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int right = minHealth[i][j + 1];
                int down = minHealth[i + 1][j];
                minHealth[i][j] = Math.max(1,Math.min(right,down) - dungeon[i][j]);
            }
        }
        return minHealth[0][0];
    }
}
