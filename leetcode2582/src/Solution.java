class Solution {
    public int passThePillow(int n, int time) {
        time %= (n-1)*2;
        return time < n ? (time+1) : (2*n-time-1);
    }
}