public class Solution2 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int l = Math.min(start,destination);
        int r = Math.max(start,destination);
        int length1 = 0, length2 = 0;
        //先计算顺时针
        for (int i = l; i < r; i++) length1 += distance[i];
        //再计算逆时针
        for (int i = l - 1; i >= 0; i--) length2 += distance[i];
        for (int i = r; i < distance.length; i++) length2 += distance[i];

        return Math.min(length1,length2);
    }

    public static void main(String[] args) {
        int[] distance = {14,13,4,7,10,17,8,3,2,13};
        int start = 2, destination = 9;
        System.out.println(new Solution2().distanceBetweenBusStops(distance,start,destination));
    }
}
