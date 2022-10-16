import java.util.Arrays;
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i],i);
        }
        return build(preorder,inorder,0,n-1,0,n-1);
    }

    //前序遍历数组是[根节点,[左子树],[右子树]]，中序遍历数组是[[左子树],根节点,[右子树]]
    private TreeNode build(int[] preorder,int[] inorder,int pl,int pr,int il,int ir) {
        if (pl > pr || il > ir) return null;
        //找到中序遍历数组当中根节点所在索引
        int i = map.get(preorder[pl]);
        TreeNode root = new TreeNode(preorder[pl]);
        //注意不能用i直接代表左子树数组长度
        int leftLength = i - il;
        root.left = build(preorder,inorder,pl+1,pl + leftLength,il,i-1);
        root.right = build(preorder,inorder,pl + leftLength + 1,pr,i+1,ir);
        return root;
    }
}