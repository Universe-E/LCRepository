class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int s1 = getScore(player1),s2 = getScore(player2);
        return s1 == s2 ? 0 : s1 > s2 ? 1 : 2;
    }

    private int getScore(int[] player) {
        int n = player.length, s = 0;
        for (int i = 0; i < n; i++) {
            if ((i >= 1 && player[i-1] == 10) || (i >= 2 && player[i-2] == 10)) s += 2*player[i];
            else s += player[i];
        }
        return s;
    }
}