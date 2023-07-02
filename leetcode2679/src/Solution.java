import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int matrixSum(int[][] nums) {
        int n = nums.length, m = nums[0].length;
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        int res = 0;
        for (int j = m-1; j >= 0; j--) {
            int mx = 0;
            for (int i = 0; i < n; i++) {
                mx = Math.max(mx,nums[i][j]);
            }
            res += mx;
        }
        return res;
    }
}