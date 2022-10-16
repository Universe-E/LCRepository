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
