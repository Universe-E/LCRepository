import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        var q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            q.addLast(i);
        }
        int[] res = new int[n];
        Arrays.sort(deck);
        for (int num : deck) {
            res[q.pollFirst()] = num;
            if (!q.isEmpty()) q.addLast(q.pollFirst());
        }
        return res;
    }
}