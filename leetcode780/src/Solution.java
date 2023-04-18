class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx==sx && ty==sy) return true;
            //每次都直接减到离sy最近的一个值
            if (ty > tx) {
                ty -= Math.max((ty-sy)/tx,1) * tx;
            }
            else {
                tx -= Math.max((tx-sx)/ty,1)*ty;
            }
        }
        return false;
    }
}