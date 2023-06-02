import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        ArrayList<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g,e->new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (inArea(bombs[i],bombs[j])) g[i].add(j);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            var q = new ArrayDeque<Integer>();
            var v = new boolean[n];
            q.addLast(i);
            v[i] = true;
            int cnt = 1;
            while (!q.isEmpty()) {
                int p = q.pollFirst();
                for (Integer y : g[p]) {
                    if (!v[y]) {
                        q.addLast(y);
                        v[y] = true;
                        cnt++;
                    }
                }
            }
            res = Math.max(res,cnt);
        }
        return res;
    }

    //判断arr2是否在arr1的爆炸范围内
    private boolean inArea(int[] arr1,int[] arr2) {
        return (long)Math.pow(arr1[0]-arr2[0],2) + (long)Math.pow(arr1[1]-arr2[1],2) <= (long)Math.pow(arr1[2],2);
    }
}