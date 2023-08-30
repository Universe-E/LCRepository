import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        var q = new ArrayDeque<int[]>();
        var v = new HashSet<Integer>();
        q.addLast(new int[]{0,1,0});
        v.add(0);
        //最大可能点为max(max(f)+a,x)+b
        int bound = Math.max(x,Arrays.stream(forbidden).max().getAsInt()+a)+b;
        var f = new HashSet<Integer>();
        for (int i : forbidden) {
            f.add(i);
        }
        while (!q.isEmpty()) {
            int[] arr = q.pollFirst();
            int p =arr[0],d = arr[1],s = arr[2];
            if (p == x) return s;
            //将下一步的状态加入队列
            int p2 = p+a,d2 = 1;
            if (p2 >= 0 && p2 <= bound && !f.contains(p2) && !v.contains(p2*d2)) {
                v.add(p2*d2);
                q.addLast(new int[]{p2,d2,s+1});
            }
            //如果当前是向前走，考虑从当前位置向后退一步的可能
            if (d == 1) {
                p2 = p-b;
                d2 = -1;
                if (p2 >= 0 && p2 <= bound && !f.contains(p2) && !v.contains(p2*d2)) {
                    v.add(p2*d2);
                    q.addLast(new int[]{p2,d2,s+1});
                }
            }
        }
        return -1;
    }
}