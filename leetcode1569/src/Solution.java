class TreeNode {
    TreeNode left,right;
    int val;
    public TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public static final int M = (int) 1e9+7;
    int[][] c;
    public int numOfWays(int[] nums) {
        int n = nums.length;
        //precalculate combination：C(j,n) = C(j,n-1)+C(j-1,n-1)
        c = new int[n+1][n+1];
        c[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                c[i][j] = (c[i-1][j] + c[i-1][j-1])%M;
            }
        }
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < n; i++) {
            insert(root,nums[i]);
        }
        //subtract the original way
        return (dfs(root)[1]-1+M)%M;
    }

    //constructing BST
    private void insert(TreeNode node,int val) {
        TreeNode cur = node, parent = null;
        assert cur != null;
        //find the parent of insert place
        while (cur != null) {
            parent = cur;
            if (val < cur.val) cur = cur.left;
            else cur = cur.right;
        }
        if (val < parent.val) parent.left = new TreeNode(val);
        else parent.right = new TreeNode(val);
    }

    //arr[0]: size, arr[1]: ways
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[] {0,1};
        int[] la = dfs(node.left),ra = dfs(node.right);
        int size = la[0]+ra[0]+1;
        // select la[0](or la[1]) in all nodes, equals to:
        // c[la[0]+ra[0]][la[0]] = c[la[0]+ra[0]][ra[0]]
        // for each selection: left node has la[1] ways, right node has ra[1] ways
        int ways = (int) ((long)(c[la[0]+ra[0]][la[0]])*la[1]%M*ra[1]%M);
        return new int[] {size,ways};
    }
}
