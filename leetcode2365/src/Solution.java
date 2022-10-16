import java.util.ArrayDeque;

class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        ArrayDeque<Integer> aq = new ArrayDeque<>(space);
        int i = 0;
        long res = 0;
        //每次循环前用0将队列填满
        while (aq.size() != space) aq.add(0);
        while (i < tasks.length) {
            //如果不包含该元素，直接添加进入
            if (!aq.contains(tasks[i])) {
                aq.poll();
                aq.add(tasks[i]);
                i++;
            }
            //如果包含该元素，则继续等待，
            else {
                aq.poll();
                aq.add(0);
            }
            //过完一天
            res++;
        }
        return res;
    }
}
