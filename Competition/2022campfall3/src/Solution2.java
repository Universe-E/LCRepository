public class Solution2 {
    public int beautifulBouquet(int[] flowers, int cnt) {
        int n = flowers.length;
        int[] dp = new int[100002];
        long res = 0;
        int j = 0;
        int M = (int) (1e9 + 7);
        for (int i = 0; i < n; i++) {
            dp[flowers[i]]++;
            //dp数组表示的是当前滑动窗口内每种花朵的数量
            //如果dp[flowers[i]]自增后大于cnt，则将该点之前所有遍历过的flowers[i]在dp数组中减去，
            //并让j自增到某一点使得dp[flowers[i]]重新等于cnt，此时的j作为新的起点
            //这样的话，对于后面每一个flowers[i]，从左边界遍历到flowers[i]可以做到不重不漏
            while (dp[flowers[i]] > cnt) {
                dp[flowers[j]]--;
                j++;
            }
            res += i - j + 1;
        }
        return (int) (res % M);
    }
}
