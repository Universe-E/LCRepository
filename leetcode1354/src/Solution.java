import java.util.*;

class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        for (int tar : target) {
            sum += tar;
            pq.add((long) tar);
        }
        //过程：[9,3,5] -> 取出9，得到[1,3,5]，再加入1 ->取出5，得到[1,3,1]，再加入1
        //但直接这样会超时，[1,1000000000]过不去
        while (!pq.isEmpty() && pq.peek() > 1) {
            long t = pq.poll();//得到target中最大的元素
            long rem = sum - t;//得到剩余的元素和
            if (rem >= t || rem < 1) return false;
            long prev = (t % rem == 0) ? rem : (t % rem);
            sum = sum - t + prev;//更新替换之后的总和
            pq.add(prev);
        }
        return true;
    }
}