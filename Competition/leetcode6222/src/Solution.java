class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        //find the nearest upper long integer that can divide Math.pow(10,n)
        long sum = 0;
        int i = 1;
        while (sumOfDigits(n) > target) {
            long tenP = (long) Math.pow(10,i);
            long re = n % tenP;
            n += tenP - re;
            sum += tenP - re;
            i++;
        }
        return sum;
    }

    private int sumOfDigits(long n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        long n = 467;
        System.out.println(new Solution().makeIntegerBeautiful(n,3));
    }
}