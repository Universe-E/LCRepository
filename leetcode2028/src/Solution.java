import java.util.Arrays;

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length, total = mean * (m + n), sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        //1、全取1也比total大
        //2、全取6还比total小
        if (sum + n > total || sum + 6 * n < total) return new int[]{};
        int[] res = new int[n];
        int rem = total - sum;
        int avg = rem / n;
        Arrays.fill(res, avg);
        rem -= n * avg;
        int i = 0;
        while (rem > 0) {
            res[i++]++;
            rem--;
        }
        return res;
    }
}