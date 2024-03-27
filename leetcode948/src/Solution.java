import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        Arrays.sort(tokens);
        //get score from token[l], get power from token[r]
        int l = 0,r = n-1,res = 0;
        while (l <= r) {
            // face down token[r] when power < token[l]
            if (power < tokens[l]) {
                if (res == 0) return res;
                else {
                    power += tokens[r--];
                    res--;
                }
            }
            power -= tokens[l++];
            res++;
        }
        return res;
    }
}