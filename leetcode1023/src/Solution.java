import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        int m = pattern.length();
        for (String query : queries) {
            boolean b = true;
            int n = query.length(),j = 0;
            for (int i = 0; i < n; i++) {
                char c = query.charAt(i);
                if (j == m) {//此时不能再出现大写字母
                    if (Character.isUpperCase(c)) {
                        b = false;
                        break;
                    }
                }
                else {
                    char c2 = pattern.charAt(j);
                    if (Character.isUpperCase(c)) {//如果i为大写字母，必须和j匹配，否则退出
                        if (c != c2) {
                            b = false;
                            break;
                        }
                        j++;
                    }
                    //如果不是大写字母，正常匹配即可
                    else if (c == c2) j++;
                }
            }
            //最后检查pattern是否已经匹配完毕，如果没有匹配完毕依然返回false
            if (b) b = j==m;
            res.add(b);
        }
        return res;
    }
}