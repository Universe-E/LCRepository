import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        //按预定时间排序
        int m = meetings.length;
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        //第一位：房间编号，第二位：结束时间，第三位，参会次数；排序规则：
        //1、结束时间最早的放在前面
        //2、如果同时结束，编号小的排在前面
        //注意要用long型，不然会整型溢出
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) return (int) (o1[0] - o2[0]);
            if (o1[1] < o2[1]) return -1;
            else return 1;
        });
        //初始化会议室
        for (int i = 0; i < n; i++) {
            pq.add(new long[] {i,0,0});
        }

        for (int[] meeting : meetings) {
            //每一次将“结束时间”更早的会议室同步到当前的startTime（即meeting[0]），其它被占用的会议室不变
            while (!pq.isEmpty() && pq.peek()[1] < meeting[0]) {
                long[] primary = pq.poll();
                primary[1] = meeting[0];
                pq.add(primary);
            }
            long[] room = pq.poll();
            pq.add(new long[]{room[0], Math.max(room[1], meeting[0]) + meeting[1] - meeting[0], room[2] + 1});
        }
        int res = -1,cur = -1;
        for (long[] longs : pq) {
            System.out.println(Arrays.toString(longs));
            if (longs[2] > cur) {
                res = (int) longs[0];
                cur = (int) longs[2];
            }
            if (longs[2] == cur) res = (int) Math.min(res,longs[0]);
        }
        return res;
    }
}