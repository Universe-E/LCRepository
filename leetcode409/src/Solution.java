class Solution {
    public int longestPalindrome(String s) {
        int[] cnt = new int[52];
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) cnt[c-'A']++;
            if (Character.isLowerCase(c)) cnt[c-'a'+26]++;
        }
        int res = s.length(),odd = 0;
        //回文串最多存在一个奇数次数的字符，如果有多个（>= 2）奇数次数字符，则要抛弃到只剩1个
        for (int i = 0; i < 52; i++) {
            if (cnt[i]%2 != 0) odd++;
        }
        if (odd == 0) return res;
        return res - odd + 1;
    }
}