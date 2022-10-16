class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int pre = 0,min = Integer.MAX_VALUE, p = -1;
        for (int i = 0; i < n; i++) {
            pre += gas[i] - cost[i];
            if (pre < min) {
                min = pre;
                p = i;
            }
        }
        if (pre < 0) return - 1;
        if (min >= 0) return 0;
        return p+1;
    }
}
