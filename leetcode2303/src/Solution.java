class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0;
        for (int i = 0; i < brackets.length; i++) {
            int diff = Math.min(income,brackets[i][0]-(i==0?0:brackets[i-1][0]));
            if (diff == 0) break;
            income -= diff;
            res += (double)(diff*brackets[i][1])/100;

        }
        return res;
    }
}