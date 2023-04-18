import java.util.HashSet;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            int exp = getFloor3(n);
            n -= Math.pow(3,exp);
            if (set.contains(exp)) return false;
            set.add(exp);
        }
        return true;
    }

    //return the biggest exponent of 3
    private int getFloor3(int n) {
        int res = 19;
        while (Math.pow(3,res) > n) res--;
        return res;
    }
}