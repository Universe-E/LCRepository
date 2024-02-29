import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

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
    TreeSet<Integer> set = new TreeSet<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        dfs(root);
        List<List<Integer>> res = new ArrayList<>();
        for (Integer query : queries) {
            List<Integer> cur = new ArrayList<>();
            int q = query;
            int min = set.floor(q) == null ? -1 : set.floor(q),
                    max = set.ceiling(q) == null ? -1 : set.ceiling(q);
            cur.add(min);
            cur.add(max);
            res.add(cur);
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

class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return queries.stream().parallel()
                .map(query -> floorAndCeiling(list, query))
                .toList();
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root != null) {
            dfs(root.left, list);
            list.add(root.val);
            dfs(root.right, list);
        }
    }

    private List<Integer> floorAndCeiling(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        int floorIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) {
                floorIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        Integer ceiling = -1;
        if (floorIndex != -1 && list.get(floorIndex) == target) {
            ceiling = target;
        } else if (floorIndex + 1 < list.size()) {
            ceiling = list.get(floorIndex + 1);
        }
        return List.of(floorIndex == -1 ? -1 : list.get(floorIndex), ceiling);
    }
}