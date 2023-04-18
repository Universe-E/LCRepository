class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length, res = -1, curTime = 1;
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            //如果当前点未被访问过，则尝试从该点出发寻找环
            if (times[i] == 0) {
                int start = curTime;
                for (int j = i; j >= 0; j = edges[j]) {
                    if (times[j] > 0) {
                        //找到一个新环，该环的“节点”不会在起始点之前
                        //经过旧节点但是不成环的话，是times[j] < start，但此时一定不是新环
                        if (times[j] >= start) res = Math.max(res,curTime-times[j]);
                        break;
                    }
                    times[j] = curTime++;
                }
            }
        }
        return res;
    }
}