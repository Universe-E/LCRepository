import java.util.Arrays;
import java.util.OptionalInt;

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
    public TreeNode constructMaximumBinaryTree(int[] nums){
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);

        int[] res = getMax(nums);
        int max = res[0],ptr = res[1];
        TreeNode root = new TreeNode(max);
        int[] arrLeft = new int[ptr],arrRight = new int[nums.length - ptr - 1];
        System.arraycopy(nums,0,arrLeft,0,arrLeft.length);
        System.arraycopy(nums,ptr + 1,arrRight,0,arrRight.length);
        root.left = constructMaximumBinaryTree(arrLeft);
        root.right = constructMaximumBinaryTree(arrRight);
        return root;
    }

    private int[] getMax(int[] nums) {
        int res = Integer.MIN_VALUE,ptr = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > res) {
                res = nums[i];
                ptr = i;
            }
        }
        return new int[] {res,ptr};
    }
}
