import java.util.Arrays;

class Solution {
    public int getMaximumConsecutive(int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);
        if (coins[0] != 1) return 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            //coins[i-1]前面所有元素组合的res能够覆盖coins[i]和coins[i-1]之间的gap
            //i-1之前所有元素的组合是0到res-coins[i-1]，gap记作coins[i]-coins[i-1]-1
            //例如：[1,1,3,4,10]的gap分别为-1,1,0,5，
            if (res >= coins[i]-1) {
                res += coins[i];
            }
            //否则无法覆盖gap
            else break;
        }
        return res+1;
    }
}