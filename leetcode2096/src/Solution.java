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
    String ls,rs;
    StringBuilder sb = new StringBuilder();
    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(root,startValue,destValue);
        dfs(root, startValue, destValue);
        int share = 0;
        for (int i = 0; i < Math.min(ls.length(), rs.length()); i++,share++) {
            if (ls.charAt(i) != rs.charAt(i)) break;
        }
        StringBuilder res = new StringBuilder();
        for (int i = share; i < ls.length(); i++) {
            res.append("U");
        }
        for (int i = share; i < rs.length(); i++) {
            res.append(rs.charAt(i));
        }
        return res.toString();
    }

    private void dfs(TreeNode node,int startValue,int destValue) {
        if (node.val == startValue) ls = sb.toString();
        if (node.val == destValue) rs = sb.toString();
        if (ls != null && rs != null) return;
        if (node.left != null) {
            sb.append("L");
            dfs(node.left,startValue,destValue);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (node.right != null) {
            sb.append("R");
            dfs(node.right, startValue,destValue);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}