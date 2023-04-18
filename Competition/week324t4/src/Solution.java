class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int x = queries[i][0], y = queries[i][1];
            int xD = getDepth(x), yD = getDepth(y);
            int anc = getAncestor(x,y);
            int ancD = getDepth(anc);
            //环长度 = 深度之和 + 1（添加的边） - 重复线段长度（即最近公共祖先的深度）*2
            res[i] = xD + yD + 1 - 2*ancD;
        }
        return res;
    }

    private int getDepth(int x) {
        if (x == 1) return 0;
        return (int) (Math.log(x) / Math.log(2));
    }

    private int getFather(int x) {
        if (x == 1) return 1;
        return (x%2==0) ? (x/2) : ((x-1)/2);
    }

    //find the nearest ancestor
    private int getAncestor(int x,int y) {
        int xD = getDepth(x), yD = getDepth(y);
        while (xD > yD) {
            x = getFather(x);
            xD = getDepth(x);
        }
        while (xD < yD) {
            y = getFather(y);
            yD = getDepth(y);
        }
        //find ancestor from the same depth
        while (x != y) {
            x = getFather(x);
            y = getFather(y);
        }
        return x;
    }
}