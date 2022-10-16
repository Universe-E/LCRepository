import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) return m * n;
        Arrays.sort(ops, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        int a = ops[0][0], b = Integer.MAX_VALUE;
        for (int i = 0; i < ops.length; i++) {
            if (i >= 1 && ops[i][0] == ops[i - 1][0]) continue;
            b = Math.min(b,ops[i][1]);
        }
        return a * b;
    }
}
