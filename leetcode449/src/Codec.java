import java.util.ArrayList;
import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Codec {

    ArrayList<Integer> list = new ArrayList<>();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        if (list.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i)).append(',');
        }
        sb.append(list.get(list.size()-1));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] ss = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        for (int i = 1; i < ss.length; i++) {
            int v = Integer.parseInt(ss[i]);
            root = siftDown(root,v);
        }
        return root;
    }

    private TreeNode siftDown(TreeNode root, int v) {
        TreeNode cur = root;
        while (cur != null) {
            if (v < cur.val) {
                if (cur.left != null) cur = cur.left;
                else {
                    cur.left = new TreeNode(v);
                    return root;
                }
            }
            else {
                if (cur.right != null) cur = cur.right;
                else {
                    cur.right = new TreeNode(v);
                    return root;
                }
            }
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}