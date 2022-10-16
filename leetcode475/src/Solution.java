import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        for (int house : houses) {
            int[] nearest = findNearest(house, heaters);
            int l = nearest[0], r = nearest[1];
            int curDistance = Math.min(Math.abs(house - heaters[l]), Math.abs(heaters[r] - house));
            res = Math.max(res, curDistance);
        }
        return res;
    }

    //找到包含house的左侧最大值
    private int[] findNearest(int house,int[] heaters) {
        int l = 0,r = heaters.length - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (heaters[mid] <= house) l = mid;
            else r = mid - 1;
        }
        int leftNearest = l;
        int rightNearest = heaters[leftNearest] == house ? leftNearest : Math.min(leftNearest + 1,heaters.length - 1);
        return new int[] {leftNearest, rightNearest};
    }
}
