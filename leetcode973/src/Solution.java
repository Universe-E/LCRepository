import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        Arrays.sort(points, Comparator.comparingInt(this::getDistance));
        for (int i = 0; i < k; i++) System.arraycopy(points[i],0,res[i],0,2);
        return res;
    }

    private int getDistance(int[] arr) {
        return arr[0]*arr[0] + arr[1]*arr[1];
    }
}