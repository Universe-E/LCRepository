class Solution {
    public int findIntegers(int n) {
        //递推式：S -> 10S | 0S，在长度为n-2的字符串左侧加10；在长度为n-1的字符串左侧加0。
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int len = getLength(n);
        int pre = 0,res = 0;
        //注意，要从len - 1开始，记录1的左移位数，因为1本身就是第一位
        for (int i = len - 1; i >= 0; i--) {
            int cur = 1 << i;
            //如果当前位是1
            if ((n & cur) != 0) {
                res += dp[i];//先将第i位为0的所有情况添加到结果中
                if (pre == 1) break;
                pre = 1;
            }
            //如果当前位不是1
            else pre = 0;
            //如果遍历到了最后一位，由于后面没有数字，故0和1都符合条件，因此需要自增1
            if (i == 0) res++;
        }
        return res;
    }

    //找到最高位的1，即为当前二进制数的位数
    private int getLength(int n) {
//        return Integer.toBinaryString(n).length();
        for (int i = 30; i >= 0; i--) {
            if (((n >> i) & 1) == 1) return i + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findIntegers(5));
    }
}
