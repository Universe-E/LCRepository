import java.util.Arrays;

class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int[] cnt1 = new int[14], cnt2 = new int[4];
        for (int rank : ranks) {
            cnt1[rank]++;
        }
        for (char suit : suits) {
            cnt2[suit-'a']++;
        }
        for (int i = 0; i < 4; i++) {
            if (cnt2[i] == 5) return "Flush";
        }
        Arrays.sort(cnt1);
        if (cnt1[13] >= 3) return "Three of a Kind";
        else if (cnt1[13] == 2) return "Pair";
        else return "High Card";
    }
}