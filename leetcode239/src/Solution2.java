import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        //按nums[i]从小到大添加索引i
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (nums[o1] == nums[o2] ? o1 - o2 : nums[o2] - nums[o1]));
        for (int i = 0; i < k; i++) pq.add(i);
        for (int i = 0; i < n - k + 1; i++) {
            if (i != 0) {
                pq.add(i + k - 1);
                //如果最大值所在索引已经小于了左边界，则移除
                while (pq.peek() < i) pq.poll();
            }
            res[i] = nums[pq.peek()];
        }
        return res;
    }
}