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
