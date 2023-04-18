import java.util.Arrays;

class Solution {
    public int minimumSize(int[] nums, int op) {
        int l = 1, r = Arrays.stream(nums).max().getAsInt();
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(mid, nums, op)) r = mid;
            else l = mid + 1;
        }
        return r;
    }
    boolean check(int mid, int[] nums, int op) {
        for (int x : nums) op -= (x - 1)/ mid;
        return op >= 0;
    }
}
