class Solution {
    int res;
    int[] parents;
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        res = n;
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i],strs[j])) union(i,j);
            }
        }
        return res;
    }

    private int findParent(int x) {
        if (x != parents[x]) parents[x] = findParent(parents[x]);
        //对于非根节点，当前x肯定不是parents[x]，因此不能直接return x，而是要return parents[x]
        return parents[x];
    }

    private void union(int x,int y) {
        int px = findParent(x);
        int py = findParent(y);
        if (px == py) return;
        parents[px] = parents[py];
        res--;
    }

    private boolean isSimilar(String s1, String s2) {
        int cnt = 0, len = s1.length();
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
            if (cnt > 2) return false;
        }
        return true;
    }
}