import java.util.Arrays;

class Solution {
    char[] cs;
    int[][] dp;
    public int numDupDigitsAtMostN(int n) {
        cs = String.valueOf(n).toCharArray();
        int m = cs.length;
        //长度为1<<10，即集合{0,1,2,3,4,5,6,7,8,9}的子集个数
        //可以理解为，用10位二进制数（即1024）存储0-9是否被选上
        dp = new int[m][1 << 10];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        //本题问的是[有重复数字]的个数，因此答案应该是n - f(i,mask,isLimit,isNum)
        return n - f(0,0b0000000000,true,false);
    }

    /**
     * 构造从高到低第i位及其之后数位的合法方案数，注意这里f记录的是[无重复数字]的个数
     * @param i 第i位要选的数字
     * @param mask 表示前面选过的数字集合，换句话说，第i位要选的数字不能在mask中。
     * @param isLimit 表示当前是否受到了n的约束。若为真，则第i位填入的数字至多为s[i]，否则可以是9。
     *                如果在受到约束的情况下填了s[i]，那么后续填入的数字仍会受到n的约束。
     * @param isNum 表示i前面的数位是否填了数字。若为假，则当前位可以跳过（不填数字），或者要填入的数字至少为1；
     *              若为真，则要填入的数字可以从0开始。
     * isLimit和isNum两个参数可适用于其它数位dp题目。
     * @return [无重复数字]的个数
     */
    private int f(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == cs.length) return isNum ? 1 : 0;
        if (!isLimit && isNum && dp[i][mask] >= 0) return dp[i][mask];
        int res = 0;
        //如果当前的第i位一直没有填任何数字，则之后的第i+1位也可以不填数字，否则一定要填数字。
        //这样是为了将数位小于m的数字统计在内
        if (!isNum) res = f(i+1,mask,false,false);
        //按照isLimit和isNum的定义，枚举要填入的数字d
        //如果当前位不能跳过（isNum为true时），d可以从0开始；否则（isNum为false时）d一定是第一个数字，必须从1开始
        //up是d的上限，如果当前有约束（isLimit为true时），up值为第i位的数字；否则（isLimit为false时），up可以取到9
        for (int d = isNum ? 0 : 1, up = isLimit ? cs[i] - '0' : 9; d <= up; d++) {
            //如果d不在mask集合中，此时满足条件
            if ((mask>>d & 1) == 0) {
                //处理mask，在mask中填入当前数字d
                //如果当前d没有到达上限up，当前就不受n的约束，isLimit为false
                res += f(i+1,mask | (1<<d),isLimit && (d==up),true);
            }
        }
        //dp数组的含义是在不受到约束时的合法方案数
        if (!isLimit && isNum) dp[i][mask] = res;
        return res;
    }
}