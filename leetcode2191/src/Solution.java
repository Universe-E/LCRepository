import java.util.Arrays;
import java.util.Objects;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        long[][] idx = new long[n][2];
        for (int i = 0; i < n; i++) {
            idx[i][0] = i;
            idx[i][1] = trans(mapping,nums[i]);
        }
        Arrays.sort(idx,(o1, o2) -> {
            if (Objects.equals(o1[1], o2[1])) return (int) (o1[0]-o2[0]);
            return Long.compare(o1[1],o2[1]);
        });
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[(int) idx[i][0]];
        }
        return res;
    }

    private long trans(int[] mapping, int num) {
        long res = 0;
        for (char c : String.valueOf(num).toCharArray()) {
            res += mapping[c-'0'];
            res *= 10;
        }
        return res;
    }
}