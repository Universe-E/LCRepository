import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        //处理分数，看哪个(o[0]+1)/(o[1]+1) - o[0]/o[1]最大
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
                //直接交叉相乘比较会整型溢出，因此要先用long记录相乘结果，再返回compare结果
                long mul = (long) (o2[1]-o2[0])*o1[1]*(o1[1]+1) - (long)(o1[1]-o1[0])*o2[1]*(o2[1]+1);
                return mul > 0 ? 1 : mul == 0 ? 0 : -1;
        });
        Collections.addAll(pq, classes);
        while (extraStudents > 0) {
            int[] aClass = pq.poll();
            aClass[0]++;
            aClass[1]++;
            pq.add(aClass);
            extraStudents--;
        }
        double rates = 0.0;
        while (!pq.isEmpty()) {
            int[] aClass = pq.poll();
            rates += (aClass[0]+0.0) /aClass[1];
        }
        return rates/n;
    }
}