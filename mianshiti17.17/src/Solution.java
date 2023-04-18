import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] multiSearch(String big, String[] smalls) {
        List<List<Integer>> list = new ArrayList<>();
        for (String small : smalls) {
            List<Integer> cur = new ArrayList<>();
            //注意，右边界不能为0，因此排除了smalls[i] = 0 的元素
            int len = small.length();
            if (len > 0) {
                for (int i = len; i <= big.length(); i++) {
                    if (small.equals(big.substring(i-len,i))) cur.add(i-len);
                }
            }
            list.add(cur);
        }
        int sz = list.size();
        int[][] res = new int[sz][];
        for (int i = 0; i < sz; i++) {
            List<Integer> cur = list.get(i);
            int curSZ = cur.size();
            res[i] = new int[curSZ];
            for (int j = 0; j < curSZ; j++) {
                res[i][j] = cur.get(j);
            }
        }
        return res;
    }
}