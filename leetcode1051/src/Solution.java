import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        int[] h = Arrays.copyOf(heights,heights.length);
        Arrays.sort(h);
        int cnt = 0;
        for (int i = 0; i < h.length; i++) {
            if (h[i] != heights[i]) cnt++;
        }
        return cnt;
    }
}