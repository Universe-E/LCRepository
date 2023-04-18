import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        //对于本题，最小距离为1（相邻），可以证明最大距离为左右边界可放置位置的平均距离
        int l = 1, r = (position[n-1] - position[0]) / (m - 1);
        while (l < r) {
            //二分法查找符合条件的d
            int d = (l + r + 1) / 2;
            //cnt记录符合条件位置的个数，方便起见，用pre记录上一个放置点，初始值为-1
            int cnt = 0, pre = -1;
            for (int pos : position) {
                //贪心，如果满足距离要求，则在当前位置放置，同时更新cnt和pre
                if (pre == -1 || pos - pre >= d) {
                    cnt++;
                    pre = pos;
                }
            }
            if (cnt >= m) l = d;
            else r = d - 1;
        }
        return l;
    }
}