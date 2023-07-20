import java.util.ArrayDeque;
import java.util.TreeMap;

class Solution {
    //yi + yj + |xi-xj| = yi + yj + xj - xi = (xj+yj) + (yi-xi),enumerate j
    public int findMaxValueOfEquation(int[][] points, int k) {
        int n = points.length,res = Integer.MIN_VALUE;
        var map = new TreeMap<Integer,Integer>();
        for (int j = 0,i = 0; j < n; j++) {
            while (i < j && points[j][0]-points[i][0] > k) {
                int b = points[i][1]-points[i][0];
                map.put(b,map.get(b)-1);
                if (map.get(b) == 0) map.remove(b);
                i++;
            }
            if (!map.isEmpty()) res = Math.max(res,points[j][0]+points[j][1]+map.lastKey());
            map.put(points[j][1]-points[j][0],map.getOrDefault(points[j][1]-points[j][0],0)+1);
        }
        return res;
    }
}

class Solution {
    //yi + yj + |xi-xj| = yi + yj + xj - xi = (xj+yj) + (yi-xi),enumerate j
    public int findMaxValueOfEquation(int[][] points, int k) {
        int res = Integer.MIN_VALUE;
        var q = new ArrayDeque<int[]>();
        //q stores (xi,yi-xi)
        for (int[] p : points) {
            int x = p[0],y = p[1];
            //pollFirst those are out of bound
            while (!q.isEmpty() && x-q.peekFirst()[0] > k) q.pollFirst();
            if (!q.isEmpty()) res = Math.max(res,x+y+q.peekFirst()[1]);
            //pollLast those are less than current element, ensure q[1] are strictly decreasing
            while (!q.isEmpty() && q.peekLast()[1] <= y-x) q.pollLast();
            q.addLast(new int[] {x,y-x});
        }
        return res;
    }
}