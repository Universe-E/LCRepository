import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        var q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                res[q.pollLast()] = nums[i];
            }
            q.addLast(i);
        }
        if (!q.isEmpty()) {
            //remaining elements can only find the next greater element in the range of [0,topId]
            int topId = q.peekFirst();
            for (int i = 0; i <= topId; i++) {
                while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                    res[q.pollLast()] = nums[i];
                }
            }
        }
        return res;
    }
}