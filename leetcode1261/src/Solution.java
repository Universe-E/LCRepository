import java.util.ArrayDeque;
import java.util.HashSet;

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

class FindElements {
    TreeNode t;
    HashSet<Integer> set;
    public FindElements(TreeNode root) {
        t = root;
        set = new HashSet<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        t.val = 0;
        q.addLast(t);
        set.add(t.val);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.pollFirst();
                assert cur != null;
                if (cur.left != null) {
                    cur.left.val = 2*cur.val+1;
                    q.addLast(cur.left);
                    set.add(cur.left.val);
                }
                if (cur.right != null) {
                    cur.right.val = 2*cur.val+2;
                    q.addLast(cur.right);
                    set.add(cur.right.val);
                }
            }
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}