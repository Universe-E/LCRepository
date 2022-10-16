import java.util.Arrays;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = players.length, n = trainers.length,res = 0;
        for (int i = 0,j = 0; i < n && j < m; i++) {
            if (trainers[i] >= players[j]) {
                res++;
                j++;
            }
        }
        return res;
    }
}