import java.util.ArrayList;
import java.util.List;

class Solution2 {
    List<TreeNode> resList = new ArrayList<>();
    public List<TreeNode> generateTrees(int n) {
        return generate(1,n);
    }

    private List<TreeNode> generate(int left,int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTrees = new ArrayList<>(),rightTrees = new ArrayList<>();
            leftTrees = generate(left,i - 1);
            rightTrees = generate(i + 1,right);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = leftTree;
                    cur.right = rightTree;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}