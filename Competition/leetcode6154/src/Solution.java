class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int res = 0, targetDepth = -1;//这里表示感染起始节点的高度为-1
    public int amountOfTime(TreeNode root, int start) {
        dfs(root,0,start);
        return res;
    }
    //dfs，顺便找到start的深度
    private int dfs(TreeNode root,int depth,int start) {
        if (root == null) return 0;
        if (root.val == start) targetDepth = depth;
        //接下来分别得出左右子树高度
        int l = dfs(root.left,depth + 1,start);
        boolean isLeft = targetDepth != -1;//判断start节点是否在左子树上，如果在，则depth一定被更新过，不等于-1
        int r = dfs(root.right, depth + 1, start);
        if (root.val == start) res = Math.max(res,Math.max(l,r));//如果当前节点即是起始节点，则看左右子树高度差
        //如果起始节点在当前节点左子树上，则当前结果等于右子树高度（r）加上起始节点到该节点的高度差（this.targetDepth - targetDepth），反之亦然
        if (isLeft) res = Math.max(res,targetDepth - depth + r);
        else res = Math.max(res,targetDepth - depth + l);
        //当前递归结束时，当前节点高度等于最大子树高度+1
        return Math.max(l,r) + 1;
    }
}
