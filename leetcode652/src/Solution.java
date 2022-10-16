import java.util.ArrayList;
import java.util.HashMap;
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

class Solution {
    HashMap<String,Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        putNode(root);
        for (String s : map.keySet()) {
            System.out.println(s);
        }
        return res;
    }

    private String putNode(TreeNode root) {
        if (root == null) return "null";
        String key;
        if (isLeaf(root)) key = String.valueOf(root.val);
        else key = root.val + "," + putNode(root.left) + "," + putNode(root.right);
        if (map.getOrDefault(key,0) == 1) res.add(root);
        map.put(key,map.getOrDefault(key,0) + 1);
        return key;
    }

    private boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }

}