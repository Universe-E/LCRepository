class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        //如果n >= 2，先考虑当前位数的情况，例如：
        //n = 2，先考虑十位数，9个数字去匹配f(1) - f(0)个一位数字，最后再加上f(1)
        //n = 3，先考虑百位数，8个数字去匹配f(2) - f(1)个两位数字，最后再加上f(2)
        //n = 4，先考虑千位数，7个数字去匹配f(3) - f(2)个三位数字，最后再加上f(3)
        //可得递推公式：f(n) = (11 - n) * (f(n - 1) - f(n - 2)) + f(n - 1)
        return (11 - n) * (countNumbersWithUniqueDigits(n - 1) - countNumbersWithUniqueDigits(n - 2))
                + countNumbersWithUniqueDigits(n - 1);
    }
}