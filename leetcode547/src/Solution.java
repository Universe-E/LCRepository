import java.util.Arrays;
import java.util.HashSet;

class Solution {
    int[] fa;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i,j);
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(i));
        }
        return set.size();
    }

    private int find(int x) {
        return x == fa[x] ? x : (fa[x] = find(fa[x]));
    }

    private void union(int x,int y) {
        int fx = find(x),fy = find(y);
        if (fx != fy) fa[fx] = fy;
    }
}