public class Solution2 {
    public static final int M = (int)1e9+7;
    public int countPalindromes(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        //pre[i]和suf[i]统计当前数字的出现次数
        int[] pre = new int[10], suf = new int[10];
        int[][] pre2 = new int[10][10], suf2 = new int[10][10];
        //先统计后缀
        for (int i = n-1; i >= 0; i--) {
            int idx = cs[i]-'0';
            //实现后缀和
            for (int j = 0; j < 10; j++) {
                suf2[idx][j] += suf[j];
            }
            suf[idx]++;
        }
        long res = 0;
        for (char c : cs) {
            int idx = c - '0';
            suf[idx]--;
            //将suf和suf2对应当前位置的后缀和减去，这样就实现了滚动
            for (int j = 0; j < 10; j++) {
                suf2[idx][j] -= suf[j];
            }
            //注意，pre2[i][j]是从左往右统计，suf2[i][j]是从右往左统计，恰好构成逆序，因此不必转换索引
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    res += (long) pre2[j][k] * suf2[j][k];
                }
            }
            //随后处理前缀数组，处理结果用于下一轮循环
            for (int j = 0; j < 10; j++) {
                pre2[idx][j] += pre[j];
            }
            pre[idx]++;
        }
        return (int)(res%M);
    }
}
