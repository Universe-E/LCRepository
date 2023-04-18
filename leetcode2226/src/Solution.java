import java.util.Arrays;

class Solution {
    public int maximumCandies(int[] candies, long k) {
        long l = 0, r = 0;
        int n = candies.length;
        for (int candy : candies) {
            r = Math.max(r, candy);
        }
        while (l < r) {
            long mid = (l + r + 1) / 2;
            long cnt = 0;
            for (int candy : candies) {
                cnt += candy / mid;
            }
            if (cnt < k) r = mid - 1;
            else l = mid;
        }
        return (int)l;
    }
    
}