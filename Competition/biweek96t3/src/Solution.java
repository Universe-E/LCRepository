import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        //按照nums2中元素的大小将索引降序排序
        Arrays.sort(idx,(o1,o2) -> (nums2[o2]-nums2[o1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long res = 0, sum = 0;
        //idx按照nums2降序排列的好处是：nums2的第idx[i]位即为最小位，记min = nums2[idx[i]]
        for (int i = 0; i < n; i++) {
            //随时存储当前的sum
            sum += nums1[idx[i]];
            pq.add(nums1[idx[i]]);
            //在i自增过程中，nums2[idx[i]]始终是最小值，因此筛nums1元素的时候无需顾虑是否会导致nums2最小值变化
            //即：所有在pq中的nums1[idx[j]]元素，对应的nums2[idx[j]]一定都>= min，出队时不会影响min，此时选择最小的元素出队即可
            if (pq.size() > k) sum -= pq.poll();
            //如果pq的大小还没有到达k，说明当前i还没遍历到能取到的最小值
            if (pq.size() == k) res = Math.max(res,sum*nums2[idx[i]]);
        }
        return res;
    }
}