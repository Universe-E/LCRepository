import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
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

class CBTInserter {

    List<TreeNode> list = new ArrayList<>();
    public CBTInserter(TreeNode root) {
        //先按层序遍历将完全二叉树放进去

        list.add(root);
        int index = 0;
        while (index < list.size()) {
            TreeNode node = list.get(0);
            assert node != null;
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
            index++;
        }
    }

    //对于任意节点的父节点索引是(i-1) / 2
    public int insert(int val) {
        TreeNode cur = new TreeNode(val);
        list.add(cur);
        TreeNode father = list.get((list.size() - 2) / 2);
        if (father.left == null) father.left = cur;
        else father.right = cur;
        return father.val;
    }

    public TreeNode get_root() {
        return list.get(0);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
