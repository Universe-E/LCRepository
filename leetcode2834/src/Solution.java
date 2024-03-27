class Solution {
    public static final int M = (int) 1e9+7;
    public int minimumPossibleSum(int n, int target) {
        //对于[1,target-1]的数字，可以一直选到min(target/2,n)
        long m = Math.min(target/2,n);
        long l = m*(m+1)/2;
        //剩下n-m个数字，从target开始选
        long m2 = n-m;
        long r = (long)target * m2 + m2*(m2-1)/2;
        return (int) ((l+r)%M);
    }
}