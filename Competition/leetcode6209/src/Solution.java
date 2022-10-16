import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        int count = 0;//记录当前右移的次数
        while (n > 0) {
            while ((n & 1) == 0) {
                n >>= 1;
                count++;
            }
            list.add((int) Math.pow(2,count));
            n >>= 1;
            count++;
        }
        int[] power = new int[list.size()];
        for (int i = 0; i < list.size(); i++) power[i] = list.get(i);
        Arrays.sort(power);
        int M = (int) (1e9+7);

        int len = queries.length;
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            int l = queries[i][0], r = queries[i][1];
            long ans = 1;
            for (int j = l; j <= r; j++) {
                ans = (ans * power[j]) % M;
            }
            answer[i] = (int) ans;
        }
        return answer;
    }
}