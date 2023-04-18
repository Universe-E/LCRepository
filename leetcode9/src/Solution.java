class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int res = 0,pre = x;//需要先将x的原值存起来
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10) return false;
            res = res * 10 + digit;
        }
        System.out.println(res);
        return res == pre;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(-1));
    }
}
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
class Solution3 {
    public boolean isPalindrome(int x) {
        long rev = 0;


    }
}
