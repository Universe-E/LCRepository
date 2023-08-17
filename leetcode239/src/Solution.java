import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr = new int[nums.length - k + 1];

        //pq即为当前滑动框内元素排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < k; i++) pq.add(new int[] {nums[i],i});
        arr[0] = pq.peek()[0];
        int l = 1,r = l + k - 1;
        while (r < nums.length) {
            //从pq中移除上一个元素，然后添加新的元素
            pq.add(new int[] {nums[r],r});
            while (pq.peek()[1] < l) pq.poll();
            arr[l] = pq.peek()[0];
            l++;
            r++;
        }
        return arr;
    }
}

class Solution {
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
