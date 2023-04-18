import java.util.PriorityQueue;

class Solution {
    public long minimumDifference(int[] nums) {
        long res = Long.MAX_VALUE;
        int n = nums.length/3;
        //按降序排序，最大堆
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1,o2) -> (o2-o1));
        //part1[i]记录从[0,i]区间有效的数组和，其中i的取值范围是[0,2n-1]
        long[] part1 = new long[2*n];
        part1[0] = nums[0];
        pq1.add(nums[0]);
        for (int i = 1; i < 2*n; i++) {
            part1[i] = part1[i-1] + nums[i];
            pq1.add(nums[i]);
            //如果优先队列满了则取出最大的元素，并从part1[i]中减去
            if (pq1.size() > n) part1[i] -= pq1.poll();
        }
        //同理，pq2按升序排序，最小堆
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        //part2[i]从后往前记录从[i,3n-1]区间有效的数组和，其中i的取值范围是[n,3n-1]
        long[] part2 = new long[2*n];
        for (int i = 3*n-1; i >= n; i--) {
            //对于part2，所有的索引要位移n
            part2[i-n] = (i==(3*n-1) ? 0 : part2[i+1-n]) + nums[i];
            pq2.add(nums[i]);
            //如果最小堆满了则取出最小的元素
            if (pq2.size() > n) part2[i-n] -= pq2.poll();
            //进入交叉区间[n,2n-1]之后，可以直接比较
            if (i <= 2*n) res = Math.min(res,part1[i-1]-part2[i-n]);
        }
        return res;
    }
}