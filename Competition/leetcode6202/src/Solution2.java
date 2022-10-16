import java.util.ArrayList;

class Solution2 {
    public String robotWithString(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        ArrayList<Integer>[] listArr = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            listArr[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            listArr[cs[i] - 'a'].add(i);
        }
        StringBuilder res = new StringBuilder();
        int p = 0;
        while (p < n) {
            //找到排在最前面的最小字母索引cur，要求cur不能排在p之前
            int cur = -1;
            while (cur < p) {
                for (int i = 0; i < 26; i++) {
                    if (listArr[i].size() != 0) {
                        cur = listArr[i].remove(0);
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = p; i <= cur; i++) {
                sb.append(cs[i]);
            }
            res.append(sb.reverse().toString());
            p = cur + 1;
        }
        return res.toString();
    }
}