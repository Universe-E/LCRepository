import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return serializer(root, sb).toString();

    }

    //按前序遍历构造序列化的二叉树
    private StringBuilder serializer(TreeNode root,StringBuilder sb) {
        if (root == null) return sb.append("null,");
        sb.append(root.val);
        sb.append(",");
        sb = serializer(root.left,sb);
        sb = serializer(root.right, sb);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(nodes));
        return deserializer(list);
    }

    private TreeNode deserializer(ArrayList<String> list) {
        if (list.get(0).equals("null") ) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = deserializer(list);
        root.right = deserializer(list);
        return root;
    }
}