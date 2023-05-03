import java.util.TreeSet;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    TreeSet<Integer> set = new TreeSet<>();
    public int getNumber(TreeNode root, int[][] ops) {
        dfs(root);
        int n = ops.length,res = 0;
        //节点颜色只和最后一次更新颜色有关，因此倒序枚举
        for (int i = n-1; i >= 0 && !set.isEmpty(); --i) {
            int type = ops[i][0],l = ops[i][1],r = ops[i][2];
            //不断寻找大于等于l的最小值cur，并更新cur
            Integer cur = set.ceiling(l);
            while (cur != null && cur <= r) {
                //本轮出现的节点，下一轮不会再出现，因此移除
                set.remove(cur);
                if (type == 1) ++res;
                cur = set.ceiling(cur);
            }
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}