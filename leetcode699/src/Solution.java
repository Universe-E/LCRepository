import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<int[]> list = new ArrayList<>();
        //类似线段树的思路，
        //对于每一个正方形，注意不能直接在区间增加sideLength，
        //而是要找到该区间的最高点curMax，再将该区间直接赋值为curMax + sideLength
        List<Integer> res = new ArrayList<>();
        int highest = 0;
        for (int[] position : positions) {
            int curMax = 0;
            //先找到当前区间的最高点curMax
            for (int[] ints : list) {
                if (ints[0] >= position[0] + position[1] || ints[1] <= position[0]) continue;
                curMax = Math.max(curMax,ints[2]);
            }
            //该区间的高度均等于curMax+sideLength
            int height = curMax + position[1];
            list.add(new int[] {position[0],position[0] + position[1],height});
            highest = Math.max(highest, height);
            res.add(highest);
        }
        return res;
    }
}