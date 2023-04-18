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
    //map用于存储后序遍历的节点序号
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = postorder.length;
        for (int i = 0; i < n; i++) {
            map.put(postorder[i],i);
        }
        return build(preorder, 0,n-1,0,n-1);
    }

    //前序遍历是[根,[左子树],[右子树]]，后序遍历是[[左子树],[右子树],根]
    private TreeNode build(int[] preorder, int preStart, int preEnd, int postStart, int postEnd) {
        if (postStart > postEnd) return null;
        if (preStart == preEnd) return new TreeNode(preorder[preStart]);
        //先根据前序遍历确定根节点
        TreeNode root = new TreeNode(preorder[preStart]);
        //左子树的根节点就是preStart+1，在map中找到它在postorder数组中的相应位置
        int lRoot_postIndex = map.get(preorder[preStart+1]);
        //左子树的长度
        int lSize = lRoot_postIndex - postStart + 1;

        root.left = build(preorder, preStart+1,preStart+lSize,postStart,postStart+lSize-1);
        root.right = build(preorder, preStart+lSize+1,preEnd,postStart+lSize,postEnd-1);
        return root;
    }
}