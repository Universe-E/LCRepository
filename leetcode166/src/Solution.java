import java.util.HashMap;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long n = numerator,d = denominator;
        StringBuilder sb = new StringBuilder();
        if (n * d < 0) sb.append("-");
        n = Math.abs(n);
        d = Math.abs(d);
        HashMap<Long, Integer> map = new HashMap<>();
        sb.append(n / d);
        if (n % d == 0) return sb.toString();
        sb.append(".");
        n %= d;
        n *= 10;
        //如果出现重复的被除数，则设为循环节
        while (!map.containsKey(n)) {
            map.put(n,sb.length());
            sb.append(n / d);
            n %= d;
            n *= 10;
            if (n % d == 0) {
                if (n != 0) sb.append(n / d);
                break;
            }
        }
        //n % d = 0是没有循环节的情况
        if (n % d == 0) return sb.toString();
        sb.insert(map.get(n),"(");
        sb.append(")");
        return sb.toString();
    }
}