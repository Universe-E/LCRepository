import java.util.Arrays;

class Solution {
    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long sum = 0;
        for (int bean : beans) {
            sum += bean;
        }
        long res = sum;
        for (int i = 0,pre = -1; i < n; i++) {
            //skip the duplicated element
            if (beans[i] == pre) continue;
            long rem = (long)(n-i)*beans[i];
            res = Math.min(res,sum-rem);
            pre = beans[i];
        }
        return res;
    }
}