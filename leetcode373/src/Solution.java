import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        //先放进去几个元素
        for (int i = 0; i < Math.min(nums1.length,k); i++) {
            pq.offer(new int[] {i,0});
        }
        List<List<Integer>> res = new ArrayList<>();
        //放入一个取出一个，直到k次为止
        while (k > 0 && !pq.isEmpty()) {
            int[] numsIndex = pq.poll();
            List<Integer> cur = new ArrayList<>();
            cur.add(nums1[numsIndex[0]]);
            cur.add(nums2[numsIndex[1]]);
            res.add(cur);
            if (numsIndex[1] < nums2.length - 1) {
                pq.add(new int[] {numsIndex[0],numsIndex[1] + 1});
            }
            k--;
        }
        return res;
    }
}
