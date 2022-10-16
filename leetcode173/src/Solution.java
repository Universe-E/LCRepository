import java.util.ArrayList;
import java.util.List;

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

class BSTIterator {

    List<TreeNode> list;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }

    public int next() {
        return list.remove(0).val;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */