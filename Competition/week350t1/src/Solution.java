class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int cnt = 0;
        while (mainTank > 0) {
            mainTank--;
            cnt++;
            if (cnt % 5 == 0 && additionalTank > 0) {
                mainTank++;
                additionalTank--;
            }
        }
        return cnt*10;
    }
}