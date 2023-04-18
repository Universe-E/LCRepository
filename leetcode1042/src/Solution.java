import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    ArrayList<Integer>[] g;
    int[] colors;
    public int[] gardenNoAdj(int n, int[][] paths) {
        g = new ArrayList[n];
        Arrays.setAll(g,e -> new ArrayList<>());
        for (int[] path : paths) {
            g[path[0]-1].add(path[1]-1);
            g[path[1]-1].add(path[0]-1);
        }
        colors = new int[n];
        for (int i = 0; i < n; i++) {
            setColor(i);
        }
        return colors;
    }

    private void setColor(int i) {
        boolean[] flags = new boolean[5];
        for (Integer y : g[i]) {
            flags[colors[y]] = true;
        }
        //从1开始，找到第一个没出现的颜色
        for (int j = 1; j < 5; j++) {
            if (!flags[j]) {
                colors[i] = j;
                return;
            }
        }
    }
}