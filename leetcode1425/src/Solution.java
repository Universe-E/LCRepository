import java.util.ArrayDeque;

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        q.addLast(0);
        int ans = nums[0];
        for (int i = 1; i < n; ++i) {
            // 如果队首的 j 与 i 的差值大于 k，则不满足要求，弹出
            while (!q.isEmpty() && i - q.peekFirst() > k) {
                q.removeFirst();
            }
            // 此时队首的 j 即为最优的 j 值
            f[i] = Math.max(f[q.peekFirst()], 0) + nums[i];
            ans = Math.max(ans, f[i]);
            // 维护队列的单调性，不断从队尾弹出元素
            while (!q.isEmpty() && f[i] >= f[q.peekLast()]) {
                q.removeLast();
            }
            // 将 i 作为之后的新 j 值放入队尾
            q.addLast(i);
        }
        return ans;
    }
}