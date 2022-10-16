import java.util.Comparator;
import java.util.TreeMap;

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
    TreeMap<Integer,int[]> map = new TreeMap<>(Comparator.comparingInt(o -> o));
    public TreeNode reverseOddLevels(TreeNode root) {
        preOrder(root,1,0);
        preOrder2(root,1);
        return root;
    }

    //将二叉树节点按索引放入map中
    private void preOrder(TreeNode root,int index,int depth) {
        if (root == null) return;
        map.put(index,new int[] {root.val,depth});
        preOrder(root.left,2 * index,depth + 1);
        preOrder(root.right,2 * index + 1,depth + 1);
    }

    //修改二叉树节点的值
    private void preOrder2(TreeNode root,int index) {
        if (root == null) return;
        //先拿到当前层数
        int depth = map.get(index)[1];
        //如果当前是奇数层，对于奇数层是从(2 ^ depth)到(2 ^ (depth + 1) - 1)序号的值翻转
        if (depth % 2 == 1) {
            //先确定当前index是该层的第几个值
            //例如index = 10是第3层第3个，index = 14是第3层第7个
            int curPos = index - (int) Math.pow(2,depth) + 1;
            //然后拿到目标交换的index
            // 例如index = 10的swapIndex是13，index = 14的swapIndex是9
            int swapIndex = (int) Math.pow(2,depth + 1) - curPos;
            root.val = map.get(swapIndex)[0];
        }
        preOrder2(root.left, 2 * index);
        preOrder2(root.right, 2 * index + 1);
    }
}