import java.util.Arrays;

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        //先贪心
        int[][] diff = new int[n][2];
        int[] arr = new int[n];
        int cnt1 = 0,score = 0;
        for (int i = 0; i < n; i++) {
            diff[i][0] = i;
            diff[i][1] = reward1[i]-reward2[i];
            if (reward1[i] >= reward2[i]) {
                cnt1++;
                score += reward1[i];
                arr[i] = 1;
            }
            else {
                score += reward2[i];
                arr[i] = 2;
            }
        }
        if (cnt1 == k) return score;
        //如果cnt1吃多了，按照最小分差吐出来给cnt2吃，如果cnt1吃少了，同样按最小分差让cnt2喂cnt1吃
        if (cnt1 < k) {
            Arrays.sort(diff,(o1,o2) -> (o2[1]-o1[1]));
            for (int i = 0; i < n && cnt1 < k; i++) {
                if (arr[diff[i][0]] == 2) {
                    score += diff[i][1];
                    cnt1++;
                }
            }
            return score;
        }
        else {
            Arrays.sort(diff, (o1, o2) -> (o1[1]-o2[1]));
            for (int i = 0; i < n && cnt1 > k; i++) {
                if (arr[diff[i][0]] == 1) {
                    score -= diff[i][1];
                    cnt1--;
                }
            }
        }
        return score;
    }
}