import java.util.PriorityQueue;

class Solution {
    public static final int inf = 0x3f3f3f3f;
    public int findCrossingTime(int n, int k, int[][] time) {
        //效率最低的排在前面
        PriorityQueue<Integer> waitLeft = new PriorityQueue<>((o1,o2) -> {
           int t1 = time[o1][0]+time[o1][2],t2 = time[o2][0]+time[o2][2];
           return t1 == t2 ? (o2-o1) : (t2-t1);
        });
        PriorityQueue<Integer> waitRight = new PriorityQueue<>((o1,o2) -> {
            int t1 = time[o1][0]+time[o1][2],t2 = time[o2][0]+time[o2][2];
            return t1 == t2 ? (o2-o1) : (t2-t1);
        });
        //工作时间短的排在前面
        PriorityQueue<int[]> workLeft = new PriorityQueue<>((o1,o2) -> (o1[0]==o2[0]) ? (o1[1]-o2[1]) : (o1[0]-o2[0]));
        PriorityQueue<int[]> workRight = new PriorityQueue<>((o1,o2) -> (o1[0]==o2[0]) ? (o1[1]-o2[1]) : (o1[0]-o2[0]));
        int remain = n,cur = 0;
        for (int i = 0; i < k; i++) {
            waitLeft.add(i);
        }
        while (remain > 0 || !workRight.isEmpty() || !waitRight.isEmpty()) {
            //1、若workLeft或workRight中的工人完成工作，则取出放入wait中
            while (!workLeft.isEmpty() && workLeft.peek()[0] <= cur) waitLeft.add(workLeft.poll()[1]);
            while (!workRight.isEmpty() && workRight.peek()[0] <= cur) waitRight.add(workRight.poll()[1]);
            //2、若右侧有工人在等待，则取出优先级最低的过桥
            if (!waitRight.isEmpty()) {
                int id = waitRight.poll();
                cur += time[id][2];
                //右侧工人过桥之后，来到左边干活
                workLeft.add(new int[]{cur+time[id][3],id});
            }
            //3、若右侧还有箱子，此时左侧的工人过桥
            else if (remain > 0 && !waitLeft.isEmpty()) {
                int id = waitLeft.poll();
                cur += time[id][0];
                //左侧工人过桥之后，来到右边干活
                workRight.add(new int[]{cur+time[id][1],id});
                remain--;
            }
            //4、没有人需要过桥，时间过渡到workLeft和workRight中的最早完成时间，注意此时右侧一定没有未处理的箱子
            else cur = Math.max(cur, Math.min(
                    workLeft.isEmpty()?inf:workLeft.peek()[0],workRight.isEmpty()?inf:workRight.peek()[0]));
        }
        return cur;
    }
}
