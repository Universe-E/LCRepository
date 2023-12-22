class Solution {
    public int totalMoney(int n) {
        int round = n/7, rem = n%7,res = 0;
        for (int i = 0; i < round; i++) {
            res += 7*(i+4);
        }
        for (int i = 0; i < rem; i++) {
            res += i+1+round;
        }
        return res;
    }
}