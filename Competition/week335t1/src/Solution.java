class Solution {
    public int passThePillow(int n, int time) {
        int cnt = 0,cur = 1,b = 1;
        while (cnt < time) {
            if (b == 1) {
                cur++;
                if (cur == n) b = 0;
            }
            else {
                cur--;
                if (cur==1) b = 1;
            }
            cnt++;
        }
        return cur;
    }
}