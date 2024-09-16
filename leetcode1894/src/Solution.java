class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i : chalk) {
            sum += i;
        }
        if (k >= sum) k %= sum;
        for (int i = 0; i < chalk.length; i++) {
            if (k >= chalk[i]) k-= chalk[i];
            else return i;
        }
        return -1;
    }
}