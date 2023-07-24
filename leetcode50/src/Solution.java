class Solution {
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }
}

class Solution {
    public double myPow(double x, int n) {
        double res = fp(x,Math.abs(n));
        return n >= 0 ? res : 1/res;
    }

    private double fp(double x,int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double t = fp(x,n/2);
        if (n%2 == 0) return t*t;
        else return t*t*x;
    }
}
