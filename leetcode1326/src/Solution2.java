import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
    public int minTaps(int n, int[] ranges) {
        int len = ranges.length;
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = Math.max(0,i-ranges[i]);
            arr[i][1] = Math.min(n,i+ranges[i]);
        }
        //按照最左边界从小到大排序
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        int rBound = 0,cnt = 0,idx = 0;
        while (rBound < n) {
            //取出所有左边界在[0,rBound]区间的水龙头
            int newBound = 0;
            while (idx < len && arr[idx][0] <= rBound) {
                newBound = Math.max(newBound,arr[idx][1]);
                idx++;
            }
            //每次从这些水龙头中取出覆盖右边界最远的水龙头
            if (newBound==rBound) return -1;
            rBound = newBound;
            cnt++;
        }
        return cnt;
    }
}
