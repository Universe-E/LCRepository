import java.math.BigInteger;

class Solution {
    public static final int M = (int)(1e9 + 7);
    public int countAnagrams(String s) {
        String[] ss = s.split(" ");
        long res = 1;
        for (String word : ss) {
            int[] cnt = new int[26];
            long cur = 1;//先记录全排列次数
            for (int i = 0; i < word.length(); i++) {
                cnt[word.charAt(i)-'a']++;
                cur = cur * (i+1) % M;
            }
            for (int i = 0; i < 26; i++) {
                if (cnt[i] != 0) {
                    cur = cur * BigInteger.valueOf(getMod(cnt[i])).modInverse(BigInteger.valueOf(M)).intValue() % M;
                }
            }
            res = res * cur % M;
        }
        return (int) res;
    }

    private int getMod(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i % M;
        }
        return (int) res;
    }
}