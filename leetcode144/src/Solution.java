import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

class Command {
    String s;
    TreeNode node;
    Command(String s,TreeNode node) {
        this.s = s;
        this.node = node;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        //非递归方式前序遍历，栈中放入指令
        Deque<Command> stack = new ArrayDeque<>();
        stack.push(new Command("go",root));
        while (!stack.isEmpty()) {
            Command c = stack.pop();
            if (c.s.equals("print")) list.add(c.node.val);
            else {
                TreeNode cur = c.node;
                //推入栈的顺序和访问顺序相反，因为后进先出
                stack.push(new Command("print",cur));
                if (cur.right != null) stack.push(new Command("go",cur.right));
                if (cur.left != null) stack.push(new Command("go",cur.left));
            }
        }
        return list;
    }
}