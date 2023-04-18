import java.util.HashSet;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : banned) {
            set.add(value);
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                if (maxSum >= i) {
                    maxSum -= i;
                    cnt++;
                }
                else break;

            }
        }
        return cnt;
    }
}