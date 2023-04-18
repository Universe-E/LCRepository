import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        int n = s.length();
        //构建前缀和
        int[][] cnt = new int[n][26];
        cnt[0][s.charAt(0) - 'a']++;
        for (int i = 1; i < n; i++) {
            System.arraycopy(cnt[i-1],0,cnt[i],0,26);
            cnt[i][s.charAt(i) - 'a']++;
        }
        for (int[] query : queries) {
            int l = query[0], r = query[1], k = query[2];
            //回文串字母出现的频次必须是偶数（回文串长度为偶数），或者最多有一个奇数（回文串长度为奇数）
            //统计目标子串中每个字母的出现频次，看能否足够将奇数修改为偶数
            //但直接暴力寻找会超时，因此要利用前缀和
            int[] ls = l == 0 ? new int[26] : cnt[l-1];
            int[] rs = cnt[r];
            int[] count = new int[26];
            for (int i = 0; i < 26; i++) {
                count[i] = rs[i] - ls[i];
            }
            int odd = 0;
            for (int num : count) {
                if (num % 2 != 0) odd++;
            }
            //注意！需要的个数是(odd / 2)，不是odd，因为一次修改对应少去两个奇数
            res.add(k >= odd / 2);
        }
        return res;
    }
}