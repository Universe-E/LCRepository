import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //本题不是动态规划！
        //梯子用在最高处，砖头用在最矮处，用完即止
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, n = heights.length;
        while (i < n - 1) {
            if (heights[i] >= heights[i+1]) i++;
            else {
                //先用梯子，如果用完了再从最小值开始用砖头
                pq.add(heights[i+1]-heights[i]);
                if (pq.size() > ladders) bricks -= pq.poll();
                if (bricks < 0) return i;
                i++;
            }
        }
        return i;
    }
}