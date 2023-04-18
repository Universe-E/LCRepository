import java.util.Arrays;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        Arrays.sort(nums);
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1] + nums[i];
        }
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = bs(queries[i],pre);
        }
        return res;
    }

    private int bs(int target,int[] arr) {
        int l = -1, r = arr.length-1;
        while (l < r) {
            int m = (l+r+1)/2;
            if (arr[m] > target) r = m-1;
            else l = m;
        }
        return l+1;
    }
}