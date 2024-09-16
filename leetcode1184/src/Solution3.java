public class Solution3 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int l = Math.min(start,destination);
        int r = Math.max(start,destination);
        int length = 0, sum = 0;
        for (int i = 0; i < distance.length; i++) {
            sum += distance[i];
            if (i >= l && i < r) length += distance[i];
        }
        return Math.min(length,sum-length);
    }

}
