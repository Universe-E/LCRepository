class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx==fx && sy==fy) return t != 1;
        return t >= Math.max(Math.abs(sx-fx),Math.abs(sy-fy));
    }
}