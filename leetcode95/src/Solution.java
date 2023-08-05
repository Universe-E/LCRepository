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

class Solution {
    List<TreeNode> resList = new ArrayList<>();
    TreeNode root = new TreeNode();
    public List<TreeNode> generateTrees(int n) {
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        backTrack(root,0,arr,visited);
        return resList;
    }

    private void backTrack(TreeNode root,int start,int[] arr,boolean[] visited) {
        if (start == arr.length) {
            resList.add(root);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            if (start == 0) {
                root = new TreeNode(arr[i]);
            }
            else {
                TreeNode cur = root;
                while (true) {
                    if (arr[i] < cur.val) {
                        if (cur.left == null) {
                            cur.left = new TreeNode(arr[i]);
                            break;
                        }
                        else cur = cur.left;
                    }
                    else {
                        if (cur.right == null) {
                            cur.right = new TreeNode(arr[i]);
                            break;
                        }
                        else cur = cur.right;
                    }
                }
            }
            visited[i] = true;
            backTrack(root,start + 1,arr,visited);
        }
    }
}

class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generate(1,n);
    }

    private List<TreeNode> generate(int l, int r) {
        List<TreeNode> res = new ArrayList<>();
        if (l > r) {
            res.add(null);
            return res;
        }
        if (l == r) {
            res.add(new TreeNode(l));
            return res;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> ls = generate(l,i-1),rs = generate(i+1,r);
            for (TreeNode lt : ls) {
                for (TreeNode rt : rs) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = lt;
                    cur.right = rt;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}