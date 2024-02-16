import java.util.*;

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
    TreeMap<Integer,List<int[]>> map = new TreeMap<>(Comparator.comparingInt(k -> k));
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root,0,0);
        List<List<Integer>> res = new ArrayList<>();
        for (List<int[]> valList : map.values()) {
            valList.sort((o1,o2) -> ((o1[0]==o2[0]) ? (o1[1]-o2[1]) : (o1[0]-o2[0])));
            List<Integer> cur = new ArrayList<>();
            for (int[] arr : valList) {
                cur.add(arr[1]);
            }
            res.add(cur);
        }
        return res;
    }

    private void dfs(TreeNode root, int row, int col) {
        if (root == null) return;
        map.computeIfAbsent(col,e->new ArrayList<>()).add(new int[] {row, root.val});
        dfs(root.left,row+1,col-1);
        dfs(root.right,row+1,col+1);
    }

}