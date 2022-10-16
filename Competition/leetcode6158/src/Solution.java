import java.util.Arrays;

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] chars = s.toCharArray();
        int[] cs = new int[chars.length];
        // 原始字符串的每个字符的ascii码
        for (int i = 0; i < chars.length; i++) {
            cs[i] = chars[i] - 'a';
        }
        //建立差分数组
        long[] difference = new long[cs.length];
        difference[0] = cs[0];
        for (int i = 1; i < difference.length; i++) {
            difference[i] = cs[i] - cs[i - 1];
        }

        //修改差分数组，从start开始修改直到end，从end + 1起恢复原有状态
        for (int[] shift : shifts) {
            int diff = shift[2] == 1 ? 1 : -1;
            int start = shift[0], end = shift[1];
            difference[start] += diff;
            if (end < difference.length - 1) difference[end + 1] -= diff;
        }

        long[] res = new long[difference.length];
        res[0] = difference[0] % 26;
        for (int i = 1; i < res.length; i++) {
            res[i] = (res[i - 1] + difference[i]) % 26;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] < 0) res[i] += 26;
        }

        StringBuilder sb = new StringBuilder();
        for (long re : res) {
            sb.append((char)('a' + re));
        }
        return sb.toString();
    }
}
