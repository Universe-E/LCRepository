public class Solution {
    int[] fa;
    private int find(int x) {
        return x == fa[x] ? x : (fa[x] = find(fa[x]));
    }

    private void union(int x,int y) {
        int fx = find(x),fy = find(y);
        if (fx != fy) fa[fx] = fy;
    }

    private static final int[] d = new int[] {1,0,-1,0,1};


}
