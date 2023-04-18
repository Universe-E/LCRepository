import java.util.Arrays;

class Solution {
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);
        int len = stones[n-1]-stones[0]-n+1;//中间空出来的位置长度
        //如果要达到最大移动次数，新的左右边界缩减要尽量小，选择相差最小的一边移动
        int max = len - Math.min(stones[1]-stones[0]-1,stones[n-1]-stones[n-2]-1);
        int min = max;
        //如果最后游戏结束，那么一定有n个连续坐标摆满了石子。
        //如果我们要移动最少，必定要找一个石子序列，使得在n小连续的坐标内，初始时有最多的石子。
        //设想有个尺子，上面有n个刻度点，我们用这个尺子在石子从最左边到最右边移动，
        //每动一次都查看下在尺子范围内有m个石子，那么要使这个区间填满，就需要移动n-m次。
        int j = 0;
        for (int i = 0; i < n; i++) {
            //找到长度小于等于n的区间
            while (j+1 < n && stones[j+1]-stones[i]+1 <= n) j++;
            //如果区间长度为n-1，且已经连续，则需要移动2次，否则需要移动n-[区间长度]
            int len2 = j-i+1;
            int cost = n-len2;
            if (len2 == n-1 && stones[j]-stones[i]+1 == n-1) cost = 2;
            min = Math.min(min,cost);
        }
        return new int[] {min,max};
    }
}