class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int i = 0; i <= (long)num1 - (long)i * num2; i++) {
            if (i >= Long.bitCount((long) num1-(long)i*num2)) return i;
        }
        return -1;
    }
}