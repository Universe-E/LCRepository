import java.util.Arrays;

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int n = points.length;
        Integer[] arr = new Integer[n];
        for(int i = 0;i < n;i++) arr[i]=i;
        Arrays.sort(arr, (o1, o2) -> {
            int d1 = getDistance(x,y,points[o1][0],points[o1][1]);
            int d2 = getDistance(x,y,points[o2][0],points[o2][1]);
            if (d1==d2) return o1-o2;
            return d1-d2;
        });
        for (int i = 0; i < n; i++) {
            int ax = points[arr[i]][0], ay = points[arr[i]][1];
            if (ax==x || ay==y) return arr[i];
        }
        return -1;
    }

    private int getDistance(int x, int y, int ax, int ay) {
        return Math.abs(x-ax) + Math.abs(y-ay);
    }
}