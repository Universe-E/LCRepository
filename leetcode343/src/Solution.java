class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        //尽可能得到最多的3，然后在此基础上尽可能多得到2或4
        if (n % 3 == 0) {
            int exp = n / 3;
            return (int) Math.pow(3,exp);
        }
        if (n % 3 == 1) {
            int exp = n / 3 - 1;
            return (int) Math.pow(3,exp) * 4;
        }
        else {
            int exp = n / 3;
            return (int) Math.pow(3,exp) * 2;
        }
    }
}