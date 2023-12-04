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
    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }
    private int[] dfs(TreeNode node){
        if (node == null) return new int[]{0,0};
        int[] la = dfs(node.left),ra = dfs(node.right);
        int sum = node.val+la[0]+ra[0],num = 1+la[1]+ra[1];
        if (sum/num == node.val) res++;
        return new int[]{sum,num};
    }
}