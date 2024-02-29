import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g,e-> new ArrayList<>());
        for (int[] flight : flights) {
            int x = flight[0],y = flight[1],p = flight[2];
            g[x].add(new int[]{y,p});
        }
        var q = new ArrayDeque<int[]>();
        int[] arr = new int[n];
        Arrays.fill(arr,0x3f3f3f3f);
        arr[src] = 0;
        q.addLast(new int[]{src,0});
        for (int i = 0; i <= k; i++) {
            int sz = q.size();
            for (int j = 0; j < sz; j++) {
                int[] xs = q.pollFirst();
                assert xs != null;
                int x = xs[0], px = xs[1];
                for (int[] ys : g[x]) {
                    int y = ys[0], py = ys[1];
                    if (px+py < arr[y]) {
                        arr[y] = Math.min(arr[y],px+py);
                        q.addLast(new int[]{y,px+py});
                    }
                }
            }
        }
        return arr[dst] == 0x3f3f3f3f ? -1 : arr[dst];
    }
}