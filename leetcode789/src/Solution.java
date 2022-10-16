class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int route = Math.abs(target[0]) + Math.abs(target[1]);
        int min = Integer.MAX_VALUE,m = ghosts.length;
        //找到每个鬼到终点的距离
        for (int[] ghost : ghosts) {
            int cur = Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1]);
            min = Math.min(min, cur);
        }
        //你的路径要比所有鬼都要短才行
        return route < min;
    }
}