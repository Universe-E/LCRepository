import java.util.Arrays;

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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n == 0) return null;
        int mid = n / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (mid == 0) return root;
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid+1,n));
        return root;
    }
}