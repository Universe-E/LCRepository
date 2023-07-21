class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0,ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            }
            if (bill == 20) {
                //change the $10 first
                if (ten >= 1 && five >= 1) {
                    ten--;
                    five--;
                }
                else if (five >= 3) five -= 3;
                else return false;
            }
        }
        return true;
    }
}