import java.util.Arrays;

class Solution {
    int[] p;
    public long countPairs(int n, int[][] edges) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0],edge[1]);
        }
        //calculate the number of points in each group
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            cnt[find(i)]++;
        }
        System.out.println(Arrays.toString(cnt));
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (n-cnt[find(i)]);
        }
        return res/2;
    }

    private int find(int x) {
        if (x == p[x]) return x;
        p[x] = find(p[x]);
        return p[x];
    }

    private void union(int a,int b) {
        int fa = find(a),fb = find(b);
        p[fa] = fb;
    }
}