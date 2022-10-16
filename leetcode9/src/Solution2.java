import java.util.Arrays;

class Solution2 {
    public boolean isPalindrome(int x) {

        if (x < 0) return false;
        String s = String.valueOf(x);
        char[] str = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (char c : str) {
            res.append(c);
        }
        return res.reverse().toString().equals(s);


    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isPalindrome(1));
    }
}
