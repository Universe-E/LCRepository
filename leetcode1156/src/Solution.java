import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

class Solution {
    public int maxRepOpt1(String s) {
        int n = s.length(),res = 1;
        int[] cnt = new int[26],cur = new int[26],sub = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i)-'a']++;
        }
        for (int r = 0,l = 0; r < n; r++) {
            cur[s.charAt(r)-'a']++;
            //每次l前进到符合条件的地方
            while (l < r && !ok(cur)) {
                cur[s.charAt(l++)-'a']--;
            }
            for (int i = 0; i < 26; i++) {
                sub[i] = cnt[i]-cur[i];
            }
            TreeSet<Integer> set = get(cur);
            //第一种情况，全部相同
            if (set.size() == 1) res = Math.max(res,r-l+1);
            else {
                assert set.size() == 2;
                int c1 = set.pollFirst(),c2 = set.pollFirst();
                //第二种情况，外面有能替换的元素
                if (cur[c1] == 1 || cur[c2] == 1) {
                    if (cur[c1] == 1) {
                        if (sub[c2] > 0) res = Math.max(res,r-l+1);
                        else res = Math.max(res,r-l);
                    }
                    if (cur[c2] == 1) {
                        if (sub[c1] > 0) res = Math.max(res,r-l+1);
                        else res = Math.max(res,r-l);
                    }
                }
                //第三种情况，外面没有能替换的元素
                else res = Math.max(res,r-l);
            }
        }
        return res;
    }

    //符合要求的有2种情况，要么全部相同，要么最多1个字符不同
    private boolean ok(int[] cur) {
        int cnt = 0,non1 = 0;
        for (int i = 0; i < 26; i++) {
            if (cur[i] != 0) {
                cnt++;
                if (cur[i] > 1) non1++;
            }

        }
        if (cnt == 1) return true;
        //最多只能有1种字符数量大于1
        if (cnt == 2) {
            return non1 < 2;
        }
        return false;
    }

    private TreeSet<Integer> get(int[] cur) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < 26; i++) {
            if (cur[i] != 0) set.add(i);
        }
        return set;
    }
}