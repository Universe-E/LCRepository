import java.util.ArrayDeque;

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n <= 2) return false;
        var q = new ArrayDeque<Integer>();
        //每次维护k，如果不满足“从右往左单调递减”，此时更新k
        int k = Integer.MIN_VALUE;
        for (int i = n-1; i >= 0; i--) {
            //单调栈维护的是'3'，k维护的是'2'，k的来源是单调栈弹出的元素
            //即整体维护了'32'，所以只要找到比'2'小的元素即可
            if (nums[i] < k) return true;
            while (!q.isEmpty() && nums[i] > q.peekLast()) {
                k = Math.max(k,q.pollLast());
            }
            q.addLast(nums[i]);
        }
        return false;
    }
}