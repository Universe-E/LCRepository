import java.util.Arrays;

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int[] diff = new int[n];
        int score = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = reward1[i]-reward2[i];
            score += Math.max(reward1[i],reward2[i]);
        }
        Arrays.sort(diff);
        int i = n-1;
        while (i >= 0 && diff[i] > 0) i--;
        int len = n-i-1;
        if (len == k) return score;
        else if (len < k) {
            while (n-i-1 < k) {
                score += diff[i];
                i--;
            }
            return score;
        }
        else {
            while (n-i-1 > k) {
                i++;
                score -= diff[i];
            }
            return score;
        }
    }
}
