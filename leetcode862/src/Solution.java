import java.util.ArrayDeque;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] pre = new long[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i] + pre[i-1];
        }
        ArrayDeque<long[]> deque = new ArrayDeque<>();
        deque.add(new long[] {-1,0});
        int res = 100005;
        for (int i = 0; i < n; i++) {
            //如果pre[i]比末尾元素小，则一定能够取代末尾元素
            //假如pre[i]右侧存在元素pre[j]使pre[j]-pre[i-1]>=k，则在i-1之后的i也能被取代，满足“最短”的要求
            while (!deque.isEmpty() && pre[i] - deque.peekFirst()[1] >= k) {
                res = Math.min(res,i - (int) deque.peekFirst()[0]);
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast()[1] > pre[i]) deque.pollLast();
            deque.addLast(new long[] {i,pre[i]});
        }
        return res == 100005 ? -1 : (int) res;
    }
}