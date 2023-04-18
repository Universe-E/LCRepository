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
    public int minCameraCover(TreeNode root) {
        //递归到根节点，如果根节点未被覆盖，则需要加一，因为根节点不能继续向上递归
        if (minCamera(root) == 0) res++;
        return res;
    }

    //三种状态：0：无覆盖，1：安装摄像头，2：被覆盖但未安装摄像头
    private int minCamera(TreeNode root) {
        //空节点默认被覆盖
        if (root == null) return 2;
        int l = minCamera(root.left);
        int r = minCamera(root.right);
        //如果左右节点都被覆盖，则当前不被覆盖
        if (l == 2 && r == 2) return 0;
        //如果左右节点有一个未被覆盖，则当前节点必须安装摄像头
        if (l == 0 || r == 0) {
            res++;
            return 1;
        }
        //如果左右节点有一个安装了摄像头，则当前节点必定被覆盖
        return 2;
    }
}