import java.util.Arrays;

class Solution {
    public String orderlyQueue(String s, int k) {
        //如果k=1就作轮转，找到字典序最小的排序
        if (k == 1) {
            String res = s;
            for (int i = 0; i < s.length() - 1; i++) {
                s = s.substring(1) + s.charAt(0);
                if (s.compareTo(res) < 0) res = s;
            }
            return res;
        }
        else {
            char[] res = s.toCharArray();
            Arrays.sort(res);
            StringBuilder sb = new StringBuilder();
            for (char c : res) sb.append(c);
            return sb.toString();
        }
    }
}
