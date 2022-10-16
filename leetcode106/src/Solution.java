import java.util.HashMap;

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
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i],i);
        }
        return build(inorder,postorder,0,n-1,0,n-1);
    }

    //中序遍历数组：[[左子树],根节点,[右子树]]，后序遍历数组：[[左子树],[右子树],根节点]
    private TreeNode build(int[] inorder, int[] postorder, int il, int ir, int pl, int pr) {
        if (pl > pr || il > ir) return null;
        //从中序数组中拿到根节点索引
        int i = map.get(postorder[pr]);
        //右子树的长度
        int rLength = ir - i;
        TreeNode root = new TreeNode(postorder[pr]);
        root.left = build(inorder,postorder,il,i-1,pl,pr-rLength-1);
        root.right = build(inorder,postorder,i+1,ir,pr-rLength,pr-1);
        return root;
    }
}