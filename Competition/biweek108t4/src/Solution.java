import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    int n,m;
    public static final int[][] d = new int[][] {{-1,-1},{-1,0},{0,-1},{0,0}};
    private boolean inArea(int i,int j) {
        return i >= 0 && i < m-1 && j >= 0 && j < n-1;
    }
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        this.m = m;
        this.n = n;
        long[] res = new long[]{(long)(m-1)*(n-1),0,0,0,0};
        HashMap<String,Integer> map = new HashMap<>();
        for (int[] c : coordinates) {
            int x = c[0],y = c[1];
            //每一个点对(cx,cy)贡献为1
            for (int k = 0; k < 4; k++) {
                int cx = x+d[k][0],cy = y+d[k][1];
                if (inArea(cx,cy)) {
                    String key = cx+","+cy;
                    map.put(key,map.getOrDefault(key,0)+1);
                }
            }
        }
        for (String key : map.keySet()) {
            int v = map.get(key);
            res[v]++;
            res[0]--;
        }
        return res;
    }
}