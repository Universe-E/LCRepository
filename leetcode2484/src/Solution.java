class Solution {
    public static final int M = (int)1e9+7;
    public int countPalindromes(String s) {
        int n = s.length();
        if (n < 5) return 0;
        //前后缀只有"00"-"99"这100种可能，用数组记录
        //pre[i]和suf[i]分别对应[0,i]和[i,n-1]区间所有可能前缀或后缀的出现次数
        int[][] pre = new int[n][100], suf = new int[n][100];
        //前缀范围是1到n-4,后缀范围是3到n-2
        for (int i = 1; i < n - 3; i++) {
            //每一次前后缀都在上一次的基础上继续计算
            System.arraycopy(pre[i-1],0,pre[i],0,100);
            System.arraycopy(suf[n-i],0,suf[n-1-i],0,100);
            for (int j = 0; j < i; j++) {
                pre[i][(s.charAt(j)-'0')*10+(s.charAt(i)-'0')]++;
                suf[n-1-i][(s.charAt(n-1-i)-'0')*10+(s.charAt(n-1-j)-'0')]++;
            }
        }
        long res = 0;
        for (int i = 2; i < n - 2; i++) {
            //当前前缀数组为pre[i-1]，后缀数组为suf[i+1]
            for (int j = 0,k; j < 100; j++) {
                //对于pre[i-1]的每个j，得到其“逆串”，例如09->90,30->03,14->41
                if (j < 10) k = 10*j;
                else k = 10*(j%10)+(j/10);
                res = (res + (long)pre[i-1][j]*suf[i+1][k]%M)%M;
            }
        }
        return (int) res;
    }
}