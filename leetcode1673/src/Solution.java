import java.util.ArrayDeque;

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        var q = new ArrayDeque<Integer>();
        //单调栈构建最小子序列
        for (int i = 0; i < n; i++) {
            //注意不能无限取最小值，因为要保证序列长度至少为k
            //当前元素序号为i，若nums[i]满足条件，则：
            //设栈中已有q.size个元素，待取出1个元素，待加入（包括当前元素）有n-i个元素
            //q.size-1+n-i >= k
            while (!q.isEmpty() && nums[i] < q.peekLast() && (q.size()-1+n-i >= k)) {
                q.pollLast();
            }
            q.addLast(nums[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q.pollFirst();
        }
        return res;
    }
}