import java.util.Arrays;

class Solution {
    public int videoStitching(int[][] clips, int time) {
        int n = clips.length;
        //按开始时间排序，如果开始时间相同，按结束时间从大到小排序
        //排序后，相同开始时间的片段构成从左到右的包含关系，如[0,4],[0,3],[1,7],[1,6]...
        Arrays.sort(clips,(o1,o2) -> (o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]));
        if (clips[0][0] != 0) return -1;
        //dp[i]表示跳转到该点的最少次数
        int[] dp = new int[time+1];
        Arrays.fill(dp,-1);
        //dp数组初始化
        for (int i = 0; i <= Math.min(time,clips[0][1]); i++) dp[i] = 1;
        //如果左边界未被赋值，说明无法到达该片段
        for (int i = 1; i < n && clips[i][0] <= time; i++) {
            if (dp[clips[i][0]] == -1) return -1;
            //如果已经有值，则保持不变，如果从未更新过（-1），则等于该区间起点加1
            //可以证明dp[i]已更新的部分从左到右非递减
            for (int j = clips[i][0]; j <= Math.min(time,clips[i][1]); j++) {
                if (dp[j] == -1) dp[j] = dp[clips[i][0]] + 1;
            }
        }
        return dp[time];
    }
}