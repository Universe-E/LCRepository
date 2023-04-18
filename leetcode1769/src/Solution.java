import java.util.Arrays;

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int cnt = 0;
        //cnt[i] is the number of '1' from 0 to i
        //left[i] is the steps of all the balls from 0 to i move to i
        //right[i] is the steps of all the balls from i to n-1 move to i
        int[] cur = new int[n], left = new int[n], right = new int[n];
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') cnt++;
            cur[i] = cnt;
            if (i > 0) left[i] = left[i-1] + cur[i-1];
        }
        //reset cnt and cur
        cnt = 0;
        Arrays.fill(cur, 0);
        for (int i = n-1; i >= 0; i--) {
            if (boxes.charAt(i) == '1') cnt++;
            cur[i] = cnt;
            if (i < n-1) right[i] = right[i+1] + cur[i+1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = left[i]+right[i];
        }
        return res;
    }
}