public class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {
            '0','1','2','3','4','5'
        };
        new Solution().reverseString(s);
        System.out.println(s);
    }
}
