class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int closeLampInTree(TreeNode root) {
        int[] res = close(root);
        //这四种状态到全灭的次数分别是
        // a:1,b:0,c:1,d:2
        int a = res[0], b = res[1], c = res[2], d = res[3];
        return Math.min(a + 1,Math.min(b,Math.min(c + 1,d + 2)));
    }

    //总共有4种状态，全亮，全不亮，只有根亮，只有根不亮，分别记为a,b,c,d，
    //记当前节点的左右子树(l和r)到达4种状态所需要的操作次数分别是[la,lb,lc,ld]和[ra,rb,rc,rd]
    //总共分为32种情况。（例：根2表示根节点切换开关2，左1表示左子树切换开关1）
    private int[] close(TreeNode root) {
        if (root == null) return new int[] {0,0,0,0};
        int[] l = close(root.left);
        int[] r = close(root.right);
        int la = l[0],lb = l[1],lc = l[2],ld = l[3];
        int ra = r[0],rb = r[1],rc = r[2],rd = r[3];
        int a = 0,b = 0,c = 0,d = 0;
        //首先讨论当前节点灯亮的情况：
        if (root.val == 1) {
            //到达当前全亮的情况：
            //1、左右子树全亮，无需操作
            //2、左右子树全不亮，需要2次操作（左2,右2）
            //3、左右子树只有根亮，需要2次操作（根2,根3）
            //4、左右子树只有根不亮，需要2次操作（左1，右1）
            a = Math.min(la + ra,Math.min(lb + rb + 2,Math.min(lc + rc + 2,ld + rd + 2)));
            //到达当前全灭的情况：
            //1、左右子树全亮，需要1次操作（根2）
            //2、左右子树全不亮，需要1次操作（根1）
            //3、左右子树只有根亮，需要1次操作（根3）
            //4、左右子树只有根不亮，需要3次操作（左2，右2，根3）
            b = Math.min(la + ra + 1,Math.min(lb + rb + 1,Math.min(lc + rc + 1,ld + rd + 3)));
            //到达只有根亮的情况：
            //1、左右子树全亮，需要2次操作（左2，右2）
            //2、左右子树全不亮，无需操作
            //3、左右子树只有根亮，需要2次操作（左1，右1）
            //4、左右子树只有根不亮，需要2次操作（根2，根3）
            c = Math.min(la + ra + 2,Math.min(lb + rb,Math.min(lc + rc + 2,ld + rd + 2)));
            //到达只有根不亮的情况：
            //1、左右子树全亮，需要1次操作（根1）
            //2、左右子树全不亮，需要1次操作（根2）
            //3、左右子树只有根亮，需要3次操作（根2，左1，右1）
            //4、左右子树只有根不亮，需要1次操作（根3）
            d = Math.min(la + ra + 1,Math.min(lb + rb + 1,Math.min(lc + rc + 3,ld + rd + 1)));
        }
        //接下来讨论节点灯不亮的情况
        else {
            //到达当前全亮的情况：
            //1、左右子树全亮，需要1次操作（根1）
            //2、左右子树全不亮，需要1次操作（根2）
            //3、左右子树只有根亮，需要3次操作（根2,左1，右1）
            //4、左右子树只有根不亮，需要1次操作（根3）
            a = Math.min(la + ra + 1,Math.min(lb + rb + 1,Math.min(lc + rc + 3,ld + rd + 1)));
            //到达当前全灭的情况：
            //1、左右子树全亮，需要2次操作（左2，右2）
            //2、左右子树全不亮，无需操作
            //3、左右子树只有根亮，需要2次操作（左1，右1）
            //4、左右子树只有根不亮，需要2次操作（根1，根3）
            b = Math.min(la + ra + 2,Math.min(lb + rb,Math.min(lc + rc + 2,ld + rd + 2)));
            //到达只有根亮的情况：
            //1、左右子树全亮，需要1次操作（根2）
            //2、左右子树全不亮，需要1次操作（根1）
            //3、左右子树只有根亮，需要1次操作（根3）
            //4、左右子树只有根不亮，需要3次操作（左2，右2，根3）
            c = Math.min(la + ra + 1,Math.min(lb + rb + 1,Math.min(lc + rc + 1,ld + rd + 3)));
            //到达只有根不亮的情况：
            //1、左右子树全亮，无需操作
            //2、左右子树全不亮，需要2次操作（左2，右2）
            //3、左右子树只有根亮，需要2次操作（根2，根3）
            //4、左右子树只有根不亮，需要2次操作（左1，右1）
            d = Math.min(la + ra,Math.min(lb + rb + 2,Math.min(lc + rc + 2,ld + rd + 2)));
        }
        return new int[] {a,b,c,d};
    }
}