class Solution {
    public int kthGrammar(int n, int k) {
        return getK(n,k,0);
    }
    //第1行：0
    //第2行：01
    //第3行：0110
    //第4行：01101001
    //第5行：0110100110010110
    //易得f(x) = f(x-1)+f^(x-1)，其中f^(x)为f(x)翻转的结果，因此可以对半分类讨论
    //turn表示翻转次数，如果k在后半部分，回溯到上一行时需要翻转一次，翻转偶数次为0，奇数次为1
    private int getK(int n, int k,int turn) {
        if (n == 1) return turn % 2 == 0 ? 0 : 1;
        int half = (int)Math.pow(2,n-2);
        if (k <= half) return getK(n-1,k,turn);
        else return getK(n-1,k-half,turn+1);
    }
}