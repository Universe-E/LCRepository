class Solution {
    public static final int M = (int)(1e9+7);
    public int monkeyMove(int n) {
        return (int) ((fp(n)-2+M)%M);

    }

    private long fp(int n) {
        if (n == 1) return 2;
        long temp = fp(n/2);
        if (n%2 == 1) return temp*temp*2%M;
        else return temp*temp%M;

    }
}