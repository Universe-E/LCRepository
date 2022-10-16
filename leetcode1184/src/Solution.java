class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int length1 = 0, length2 = 0;
        if (destination > start) {
            //先计算顺时针的距离
            for (int i = start; i < destination; i++) length1 += distance[i];
            //再计算逆时针的距离
            for (int i = start - 1; i >= 0; i--) length2 += distance[i];
            for (int i = distance.length - 1; i >= destination; i--) length2 += distance[i];
        }
        else {
            //先计算顺时针的距离
            for (int i = start; i < distance.length; i++) length1 += distance[i];
            for (int i = 0; i < destination; i++) length1 += distance[i];
            //再计算逆时针的距离
            for (int i = start - 1; i >= destination; i--) length2 += distance[i];
        }
        return Math.min(length1, length2);
    }

    public static void main(String[] args) {
        int[] distance = {14,13,4,7,10,17,8,3,2,13};
        int start = 2, destination = 9;
        System.out.println(new Solution().distanceBetweenBusStops(distance,start,destination));
    }


}
