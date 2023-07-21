import java.util.ArrayDeque;

class Solution {
    public long maxArrayValue(int[] nums) {
        var q = new ArrayDeque<Long>();
        long res = 0;
        int n = nums.length;
        for (int i = n-1; i >= 0; i--) {
            if (q.isEmpty() || q.peekFirst() < nums[i]) q.addFirst((long)nums[i]);
            else {
                long cur = nums[i]+q.pollFirst();
                q.addFirst(cur);
            }
            res = Math.max(res,q.peekFirst());
        }
        return res;
    }
}

class Solution {
    public long maxArrayValue(int[] nums) {
        ArrayDeque<Long> deque = new ArrayDeque<Long>();
        long ans = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            if (deque.isEmpty() || deque.peek() < nums[i])
                deque.addFirst((long)nums[i]);
            else {
                long cur = nums[i]+deque.poll();
                deque.addFirst(cur);
            }
            ans = Math.max(ans,deque.peek());
        }
        return ans;
    }
}