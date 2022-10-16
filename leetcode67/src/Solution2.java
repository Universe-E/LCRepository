import java.math.BigInteger;

public class Solution2 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n = Math.max(a.length(),b.length()), carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - i - 1) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - i - 1) - '0') : 0;
            sb.append(carry % 2);
            carry /= 2;
        }
        //全部遍历完之后，如果carry有剩余，说明需要进位
        if (carry != 0) sb.append(1);
        BigInteger big = new BigInteger("123496194894194194949614964");
        System.out.println(big.multiply(new BigInteger("25535")));
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().addBinary("0","0"));
    }
}
