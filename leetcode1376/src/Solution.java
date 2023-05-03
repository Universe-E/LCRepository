import java.util.*;
class Solution {
    int res = 0;
    ArrayList<Integer>[] t;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        t = new ArrayList[n];
        Arrays.setAll(t, e-> new ArrayList<>());
        for(int i = 0; i < n; i++) {
            if (manager[i] != -1) t[manager[i]].add(i);
        }
        //dfs
        dfs(headID,0,informTime);
        return res;
    }

    private void dfs(int c, int time,int[] informTime) {
        if (t[c].isEmpty()) {
            res = Math.max(res,time);
            return;
        }
        for (Integer y : t[c]) {
            dfs(y,time + informTime[c],informTime);
        }
    }
}